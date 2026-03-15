package edu.scau.mis.pos.service.impl;

import cn.hutool.core.util.IdUtil;
import edu.scau.mis.pos.domain.Payment;
import edu.scau.mis.pos.domain.Product;
import edu.scau.mis.pos.domain.Sale;
import edu.scau.mis.pos.domain.SaleItem;
import edu.scau.mis.pos.enums.SaleStatusEnum;
import edu.scau.mis.pos.mapper.ISaleItemMapper;
import edu.scau.mis.pos.mapper.ISaleMapper;
import edu.scau.mis.pos.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {

    private Sale currentSale;

    @Autowired
    private ISaleMapper saleMapper;

    @Autowired
    private ISaleItemMapper saleItemMapper;

    /**
     * 开始新的销售
     */
    @Override
    public Sale makeNewSale() {
        currentSale = new Sale();
        Date saleDate = new Date();
        currentSale.setSaleTime(saleDate);
        String saleNo = "so-"+ IdUtil.getSnowflakeNextId();
        currentSale.setSaleNo(saleNo);
        currentSale.setStatus(SaleStatusEnum.RESERVED.getCode());
        currentSale.setTotal(new BigDecimal("0.00"));
        return currentSale;
    }

    /**
     * 实例化SaleItem
     * @param product 商品对象
     * @param quantity 数量
     */
    @Override
    public List<SaleItem> makeLineItem(Product product, int quantity) {
        // 判断商品是否已录入，未录入则新增。已录入则修改数量。
        if(!isEntered(product.getProductSn(),quantity)){
            SaleItem saleItem = new SaleItem();
            saleItem.setProduct(product);
            saleItem.setQuantity(quantity);
            currentSale.getSaleItems().add(saleItem);
        }
        return currentSale.getSaleItems();
    }

    /**
     * 判断商品是否已录入
     * 业务逻辑：如果已录入，则修改数量，否则添加saleLineItem
     * @param itemSn
     * @param quantity
     * @return
     */
    private boolean isEntered(String itemSn,int quantity){
        boolean flag = false;
        for(SaleItem si : currentSale.getSaleItems()){
            // 如果已经录入则修改数量
            if(itemSn.equals(si.getProduct().getProductSn())) {
                flag = true;
                int quantityOriginal = si.getQuantity();
                si.setQuantity(quantityOriginal + quantity);
            }
        }
        return flag;
    }

    /**
     * 结束订单商品录入
     * @return 总金额
     */
    @Override
    public BigDecimal endSale() {
        BigDecimal total = this.getTotal();
        currentSale.setTotal(total);
        currentSale.setCreateTime(new Date());
        saleMapper.insertSale(currentSale); // 插入订单
        // 将订单中商品持久化
        this.insertSaleItemsOfCurrentSale(currentSale);
        return total;
    }

    /**
     * 计算总金额
     * @return
     */
    private BigDecimal getTotal(){
        BigDecimal total = new BigDecimal(0);
        List<SaleItem> saleItemList = currentSale.getSaleItems();
        for(SaleItem si : saleItemList) {
            total = total.add(getSubTotal(si));
        }
        return total;
    }

    /**
     * 计算小计
     * @param saleItem
     * @return
     */
    private BigDecimal getSubTotal(SaleItem saleItem){
        return saleItem.getProduct().getPrice().multiply(new BigDecimal(saleItem.getQuantity()));
    }

    /**
     * 订单支付
     * @param cashTendered 付款金额
     * @return 找零
     */
    @Override
    public BigDecimal makePayment(BigDecimal cashTendered) {
        BigDecimal total = currentSale.getTotal();
        Payment payment = new Payment();
        payment.setAmount(total);
        payment.setPayTime(new Date());
        currentSale.setPayment(payment);
        currentSale.setStatus(SaleStatusEnum.PAID.getCode());
        currentSale.setUpdateTime(new Date());
        BigDecimal change = cashTendered.subtract(total);
        saleMapper.updateSale(currentSale); // 更新订单
        // 更新订单商品明细的状态和更新时间
        this.updateSaleItemsOfCurrentSaleForMakePayment(currentSale);
        return change;
    }

    /**
     * 将Sale中的saleItem存入数据库
     * @param currentSale 当前sale对象
     */
    private void insertSaleItemsOfCurrentSale(Sale currentSale) {
        List<SaleItem> saleItemList = currentSale.getSaleItems();
        for(SaleItem si : saleItemList) {
            si.setStatus(SaleStatusEnum.RESERVED.getCode());
            si.setProductId(si.getProduct().getProductId());
            si.setPrice(si.getProduct().getPrice());
            si.setDelFlag("0");
            si.setCreateTime(new Date());
            // 注意sale插入db自增生成id后才能getSaleId()取到id值
            si.setSaleId(currentSale.getSaleId());
        }
        saleItemMapper.batchInsertSaleItemOfCurrentSale(saleItemList);
    }

    /**
     * 支付后修改商品明细
     * 修改【状态】和【更新时间】
     * @param currentSale 当前sale对象
     *
     * 是否能在最后一步makePayment再持久化sale和saleItem？
     * 取决于挂单业务需求，非技术问题
     * 所谓挂单：存储订单，一定时间后再取出订单支付。
     * 本笔记代码目前后端service支持挂单。但前端界面没有提供入口按钮。
     */
    private void updateSaleItemsOfCurrentSaleForMakePayment(Sale currentSale){
        SaleItem param = new SaleItem();
        param.setSaleId(currentSale.getSaleId());
        List<SaleItem> saleItems = saleItemMapper.selectSaleItemList(param);
        for (SaleItem si : saleItems) {
            si.setStatus(SaleStatusEnum.PAID.getCode());
            si.setUpdateTime(new Date());
            // 建议动态sql写一个批量修改saleItem接口，避免创建多条更新的sql语句。
            // 同学可以自行参考笔记批量新增saleItem代码自行完成。
            saleItemMapper.updateSaleItem(si);
        }
    }

    /**
     * 修改订单明细数量
     * @param itemSn
     * @param quantity
     */
    @Override
    public List<SaleItem> changeQuantityOfSaleItem(String itemSn,int quantity){
        List<SaleItem> saleItems = currentSale.getSaleItems();
        for(SaleItem si : saleItems) {
            if (itemSn.equals(si.getProduct().getProductSn())){
                si.setQuantity(quantity);
            }
        }
        return saleItems;
    }

    /**
     * 删除订单明细
     * @param itemSn
     */
    @Override
    public List<SaleItem> deleteSaleItem(String itemSn) {
        List<SaleItem> saleItems = currentSale.getSaleItems();
        Iterator<SaleItem> iterator = saleItems.iterator();
        while (iterator.hasNext()) {
            SaleItem si = iterator.next();
            if(itemSn.equals(si.getProduct().getProductSn())){
                iterator.remove();
            }
        }
        return saleItems;
    }
}

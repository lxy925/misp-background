package edu.scau.mis.view;

import edu.scau.mis.pos.domain.Product;
import edu.scau.mis.pos.domain.Sale;
import edu.scau.mis.pos.domain.SaleItem;
import edu.scau.mis.pos.mapper.IProductMapper;
import edu.scau.mis.pos.mapper.ProductCatalog;
import edu.scau.mis.pos.service.ISaleService;
import edu.scau.mis.view.vo.SaleItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 记账本
 * GRASP:控制器
 */
@Component
public class Register {
    @Autowired
    private ISaleService saleService;

    @Autowired
    private IProductMapper productCatalog;

    private Sale currentSale;


    /**
     * 开始一次新的销售
     */
    public void makeNewSale(){
        currentSale = saleService.makeNewSale();
    }
    /**
     * 输入商品
     * @param itemSn
     * @param quantity
     */
    public List<SaleItemVo> enterItem(String itemSn, int quantity){
        Product product = productCatalog.selectProductBySn(itemSn);
        if(product != null) {
            List<SaleItem> saleItems = saleService.makeLineItem(product, quantity);
            return saleItems.stream()
                    .map(saleItem -> new SaleItemVo(saleItem.getProduct().getProductSn(), saleItem.getProduct().getProductName(), saleItem.getProduct().getPrice(), saleItem.getQuantity()))
                    .toList();
        }
        return null;
    }
    /**
     * 结束销售
     */
    public BigDecimal endSale(){
        return saleService.endSale();
    }
    /**
     * 确认支付
     * @param cashTendered
     */
    public BigDecimal makePayment(BigDecimal cashTendered){
        return saleService.makePayment(cashTendered);
    }

    /**
     * 获取销售项
     * @return
     */
    public List<SaleItemVo> getSaleItems() {
        return currentSale.getSaleItems().stream()
                .map(saleItem -> new SaleItemVo(saleItem.getProduct().getProductSn(), saleItem.getProduct().getProductName(), saleItem.getProduct().getPrice(), saleItem.getQuantity()))
                .toList();
    }
}

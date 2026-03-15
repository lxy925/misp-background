package edu.scau.mis.web.controller;

import edu.scau.mis.common.web.domain.ApiResult;
import edu.scau.mis.pos.domain.Product;
import edu.scau.mis.pos.domain.Sale;
import edu.scau.mis.pos.domain.SaleItem;
import edu.scau.mis.pos.service.IProductService;
import edu.scau.mis.pos.service.ISaleService;
import edu.scau.mis.view.vo.SaleItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private ISaleService saleService;

    @Autowired
    private IProductService productService;

    /**
     * 开始一次新的销售
     */
    @GetMapping("/makeNewSale")
    public ApiResult<Sale> makeNewSale(){
        return ApiResult.success(saleService.makeNewSale());
    }
    /**
     * 输入商品
     * @param itemSn 产品编号
     * @param quantity 数量
     */
    @PostMapping("/enterItem")
    public ApiResult<List<SaleItemVo>> enterItem(@RequestParam("itemSn") String itemSn, @RequestParam("quantity") int quantity){
        Product product = productService.getProductBySn(itemSn);
        List<SaleItem> saleItems = saleService.makeLineItem(product, quantity);
        return ApiResult.success(transformSaleItemsToSaleItemVos(saleItems));
    }
    /**
     * 结束销售
     */
    @GetMapping("/endSale")
    public ApiResult<BigDecimal> endSale(){
        return ApiResult.success(saleService.endSale());
    }
    /**
     * 确认支付
     * @param cashTendered 支付金额
     */
    @PutMapping("/makePayment")
    public ApiResult<BigDecimal> makePayment(@RequestParam("cashTendered") BigDecimal cashTendered){
        return ApiResult.success(saleService.makePayment(cashTendered));
    }

    /**
     * 修改订单明细数量
     * @param saleItemVo
     * @return
     */
    @PutMapping("/changeQuantity")
    public ApiResult<List<SaleItemVo>> changeQuantity(@RequestBody SaleItemVo saleItemVo){
        List<SaleItem> saleItems = saleService.changeQuantityOfSaleItem(saleItemVo.getItemSn(),saleItemVo.getQuantity());
        return ApiResult.success("修改订单明细数量成功",this.transformSaleItemsToSaleItemVos(saleItems));
    }

    /**
     * 删除订单明细
     * @param itemSn
     * @return
     */
    @DeleteMapping("/deleteSaleItem/{itemSn}")
    public ApiResult<List<SaleItemVo>> deleteSaleItem(@PathVariable("itemSn") String itemSn){
        List<SaleItem> saleItems = saleService.deleteSaleItem(itemSn);
        return ApiResult.success("删除订单明细成功",this.transformSaleItemsToSaleItemVos(saleItems));
    }

    /**
     * 转换传输数据
     * @param saleItems
     * @return
     */
    private List<SaleItemVo> transformSaleItemsToSaleItemVos(List<SaleItem> saleItems){
        List<SaleItemVo> saleItemVos = new ArrayList<>();
        for (SaleItem si : saleItems) {
            SaleItemVo saleItemVo = new SaleItemVo(si.getProduct().getProductSn(), si.getProduct().getProductName(), si.getProduct().getPrice(), si.getQuantity());
            saleItemVos.add(saleItemVo);
        }
        return saleItemVos;
    }
}

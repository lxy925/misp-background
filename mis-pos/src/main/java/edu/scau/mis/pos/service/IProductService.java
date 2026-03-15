package edu.scau.mis.pos.service;

import edu.scau.mis.pos.domain.Product;

import java.util.List;

public interface IProductService {
    /**
     * 根据id查询商品
     * @param productId
     * @return
     */
    Product getProductById(Long productId);
    /**
     * 根据sn查询商品
     * @param productSn
     * @return
     */
    Product getProductBySn(String productSn);
    /**
     * 查询所有商品
     * @return
     */
    List<Product> getAllProducts();

    /**
     * 根据参数查询产品列表
     * @param product
     * @return
     */
    List<Product> getProducts(Product product);

    /**
     * 添加商品
     * @param product
     * @return
     */
    int addProduct(Product product);
    /**
     * 修改商品
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 删除商品
     * @param productId
     * @return
     */
    int deleteProduct(Long productId);

    /**
     * 批量删除商品
     * @param productIds
     * @return
     */
    int deleteProductByIds(Long[] productIds);
}

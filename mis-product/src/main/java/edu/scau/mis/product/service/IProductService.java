package edu.scau.mis.product.service;

import com.github.pagehelper.PageInfo;
import edu.scau.mis.product.domain.Product;
import edu.scau.mis.product.domain.ProductQuery;

import java.util.List;

public interface IProductService {
    Product getProductById(Long productId);
    Product getProductBySn(String productSn);
    List<Product> getProductList(Product product);
    PageInfo<Product> pageList(ProductQuery queryDto);
    int addProduct(Product product);
    int updateProduct(Product product);
    int deleteProductById(Long productId);
    int deleteProductByIds(Long[] productIds);
}
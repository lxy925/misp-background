package edu.scau.mis.product.mapper;

import edu.scau.mis.product.domain.Product;
import edu.scau.mis.product.domain.ProductQuery;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface IProductMapper {
    Product selectProductById(Long productId);
    Product selectProductBySn(String productSn);
    List<Product> selectProductList(Product product);
    List<Product> selectPageList(ProductQuery queryDto);
    int insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProductById(Long productId);
    int deleteProductByIds(Long[] productIds);
}
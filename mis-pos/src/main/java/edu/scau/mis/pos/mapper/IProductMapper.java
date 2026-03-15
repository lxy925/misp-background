package edu.scau.mis.pos.mapper;

import edu.scau.mis.pos.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper
@Primary
public interface IProductMapper {
    /**
     * 查询单个产品
     * @param productId 主键
     * @return 对象
     */
    Product selectProductById(Long productId);

    /**
     * 根据产品编号查询产品
     * @param productSn
     * @return
     */
    Product selectProductBySn(String productSn);

    /**
     * 查询产品列表
     * @param product 查询参数
     * @return 对象集合
     */
    List<Product> selectProductList(Product product);

    /**
     * 查询所有产品
     * @return
     */
    List<Product> selectAllProductList();

    /**
     * 思考题：多参数查询如何编写映射器？？
     * 产品名称和分类ID查询产品
     * @param productName
     * @param productCategoryId
     * @return
     */
    List<Product> selectProductByNameAndCategoryId(
            @Param("productName") String productName,
            @Param("productCategoryId") Long productCategoryId);

    /**
     * 新增产品
     * @param product
     * @return 影响记录数
     */
    int insertProduct(Product product);

    /**
     * 修改产品
     * @param product
     * @return 影响记录数
     */
    int updateProduct(Product product);

    /**
     * 删除产品
     * @param productId 主键
     * @return 影响记录数
     */
    int deleteProductById(Long productId);

    /**
     * 批量删除产品
     * @param productIds
     * @return
     */
    int deleteProductByIds(Long[] productIds);
}

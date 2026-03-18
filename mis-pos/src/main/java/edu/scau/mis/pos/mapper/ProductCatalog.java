package edu.scau.mis.pos.mapper;


import edu.scau.mis.pos.domain.Category;
import edu.scau.mis.pos.domain.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class ProductCatalog implements ICategoryMapper, IProductMapper {
    public static final ConcurrentHashMap<String, Product> PRODUCT_CACHE = new ConcurrentHashMap<>();

    public static final ConcurrentHashMap<Long, Category> CATEGORY_CACHE = new ConcurrentHashMap<>();

    static {
        Category category1 = new Category(1L,0L,"文具-内存");
        Category category2 = new Category(2L,0L,"日用品");
        Category category3 = new Category(3L,0L,"手机");
        CATEGORY_CACHE.put(category1.getCategoryId(), category1);
        CATEGORY_CACHE.put(category2.getCategoryId(), category2);
        CATEGORY_CACHE.put(category3.getCategoryId(), category3);

        Product[] products = new Product[10];
        products[0] = new Product(1L,"1001","钢笔-内存","",new BigDecimal("65.00"), 1L,category1,null, null);
        products[1] = new Product(2L,"1002","日记本","",new BigDecimal("20.00"),1L,category1,null,null);
        products[2] = new Product(3L,"1003","铅笔盒","",new BigDecimal("45.00"),1L,category1,null,null);
        products[3] = new Product(4L,"1004","毛巾","",new BigDecimal("10.00"),2L,category2,null,null);
        products[4] = new Product(5L,"1005","香波","",new BigDecimal("80.00"),2L,category2,null,null);
        products[5] = new Product(6L,"1006","拖鞋", "",new BigDecimal("30.00"),2L, category2,null,null);
        products[6] = new Product(7L,"1007","Mate X5", "超轻薄四曲折叠，超高分辨率临境双屏",new BigDecimal("13499.00"),3L, category3,
                "https://res6.vmallres.com/pimages//uomcdn/CN/pms/202309/gbom/6942103107320/800_800_959526DD397D0C873FCE80CE67C9A0BFmp.png",
                "https://www.vmall.com/product/comdetail/index.html?prdId=10086281788718&sbomCode=2601010457506");
        products[7] = new Product(8L,"1008","Pura 70 Pro", "超聚光微距长焦，超高速风驰闪拍",new BigDecimal("6499.00"),3L, category3,
                "https://res2.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103119071/800_800_AE94E48F4A6370D6E956B4E722588A5Amp.png",
                "https://www.vmall.com/product/comdetail/index.html?prdId=10086821546239&sbomCode=2601010486504");
        products[8] = new Product(9L,"1009","Mate 60", "超可靠玄武架构，全焦段超清影像",new BigDecimal("5499.00"),3L, category3,
                "https://res8.vmallres.com/pimages//uomcdn/CN/pms/202403/gbom/6942103107719/800_800_5818B6A12914274ED24FB8FE47F1CD34mp.png",
                "https://www.vmall.com/product/comdetail/index.html?prdId=10086970184614&sbomCode=2601010453707");
        products[9] = new Product(10L,"1010","Pura 70", "超高速风驰闪拍，第二代昆仑玻璃",new BigDecimal("8499.00"),3L, category3,
                "https://res4.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103120374/800_800_606AD050130CDD9F17DBBB7EECDD9B4Amp.png",
                "https://www.vmall.com/product/comdetail/index.html?prdId=10086157311748&sbomCode=2601010486608");
        for (int i = 0; i < products.length; i++) {
            PRODUCT_CACHE.put(products[i].getProductSn(), products[i]);
        }
    }

    /**
     * 根据ID查询产品分类
     * @param categoryId
     * @return
     */
    @Override
    public Category selectCategoryById(Long categoryId){
        return CATEGORY_CACHE.get(categoryId);
    };

    /**
     * 查询所有产品分类
     * @return
     */
    @Override
    public List<Category> selectAllCategoryList(){
        return CATEGORY_CACHE.values().stream()
                .toList();
    }

    /**
     * 查询单个产品
     * @param productId 主键
     * @return 对象
     */
    @Override
    public Product selectProductById(Long productId){
        return PRODUCT_CACHE.values().stream()
                .filter(product -> Objects.equals(product.getProductId(), productId))
                .toList()
                .get(0);
    }

    /**
     * 根据产品编号查询产品
     * @param productSn
     * @return
     */
    @Override
    public Product selectProductBySn(String productSn) {
        return PRODUCT_CACHE.get(productSn);
    }


    /**
     * 查询产品列表
     * @param product 查询参数
     * @return 对象集合
     */
    @Override
    public List<Product> selectProductList(Product product) {
        Predicate<Product> filter = p -> true;
        if(product.getProductSn() != null) {
            Predicate<Product> snFilter = p -> p.getProductSn().equals(product.getProductSn());
            filter = filter.and(snFilter);
        }
        if(product.getProductName() != null) {
            Predicate<Product> nameFilter = p -> p.getProductName().contains(product.getProductName());
            filter = filter.and(nameFilter);
        }
        if(product.getProductCategoryId() != null) {
            Predicate<Product> categoryFilter = p -> Objects.equals(p.getProductCategoryId(), product.getProductCategoryId());
            filter = filter.and(categoryFilter);
        }
        return PRODUCT_CACHE.values().stream().
                filter(filter)
                .sorted(Comparator.comparing(Product::getProductId))
                .collect(Collectors.toList());
    }

    /**
     * 查询所有产品
     * @return
     */
    @Override
    public List<Product> selectAllProductList(){
        return PRODUCT_CACHE.values().stream().toList();
    }

    /**
     * 思考题：多参数查询如何编写映射器？？
     * 产品名称和分类ID查询产品
     *
     * @param productName
     * @param productCategoryId
     * @return
     */
    @Override
    public List<Product> selectProductByNameAndCategoryId(String productName, Long productCategoryId) {
        return PRODUCT_CACHE.values().stream()
                .filter(product -> product.getProductName().contains(productName) && Objects.equals(product.getProductCategoryId(), productCategoryId))
                .collect(Collectors.toList());
    }

    /**
     * 新增产品
     * @param product
     * @return 影响记录数
     */
    @Override
    public int insertProduct(Product product) {
        product.setProductId(Long.valueOf((long) (PRODUCT_CACHE.size()+1)));
        product.setCategory(CATEGORY_CACHE.get(product.getProductCategoryId()));
        PRODUCT_CACHE.put(product.getProductSn(),product);
        return 1;
    }

    /**
     * 修改产品
     * @param product
     * @return 影响记录数
     */
    @Override
    public int updateProduct(Product product) {
        product.setCategory(CATEGORY_CACHE.get(product.getProductCategoryId()));
        PRODUCT_CACHE.put(product.getProductSn(),product);
        return 1;
    }

    /**
     * 删除产品
     * @param productId 主键
     * @return 影响记录数
     */
    @Override
    public int deleteProductById(Long productId) {
        if (productId == null) {
            return 0;
        }

        // 使用 removeIf 删除匹配的 Product
        boolean removed = PRODUCT_CACHE.values().removeIf(
                product -> Objects.equals(product.getProductId(), productId)
        );

        return removed ? 1 : 0;
    }

    /**
     * 批量删除产品
     *
     * @param productIds
     * @return
     */
    @Override
    public int deleteProductByIds(Long[] productIds) {
        if (productIds == null || productIds.length == 0) {
            return 0;
        }
        for (Long productId : productIds) {
            deleteProductById(productId);
        }
        return productIds.length;
    }
}

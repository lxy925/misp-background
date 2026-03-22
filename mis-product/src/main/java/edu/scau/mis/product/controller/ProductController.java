package edu.scau.mis.product.controller;

import com.github.pagehelper.PageInfo;
import edu.scau.mis.common.web.domain.ApiResult;
import edu.scau.mis.product.domain.Product;
import edu.scau.mis.product.domain.ProductQuery;
import edu.scau.mis.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/{productId}")
    public ApiResult<Product> getById(@PathVariable("productId") Long productId) {
        Product product = productService.getProductById(productId);
        return product == null ? ApiResult.noContent() : ApiResult.success(product);
    }

    @GetMapping("/getBySn/{productSn}")
    public ApiResult<Product> getBySn(@PathVariable("productSn") String productSn) {
        Product product = productService.getProductBySn(productSn);
        return product == null ? ApiResult.noContent() : ApiResult.success(product);
    }

    @GetMapping("/page")
    public ApiResult page(ProductQuery query) {
        PageInfo<Product> pageInfo = productService.pageList(query);
        return ApiResult.success(pageInfo);
    }

    @GetMapping("/list")
    public ApiResult<List<Product>> list(Product product) {
        List<Product> list = productService.getProductList(product);
        return list.isEmpty() ? ApiResult.noContent() : ApiResult.success(list);
    }

    @PostMapping("/add")
    public ApiResult<Void> add(@RequestBody Product product) {
        productService.addProduct(product);
        return ApiResult.success();
    }

    @PutMapping("/update")
    public ApiResult<Void> update(@RequestBody Product product) {
        productService.updateProduct(product);
        return ApiResult.success();
    }

    @DeleteMapping("/{productId}")
    public ApiResult<Void> delete(@PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
        return ApiResult.success();
    }

    @DeleteMapping("/delete")
    public ApiResult<Void> deleteBatch(@RequestParam(name = "productIds") Long[] productIds) {
        productService.deleteProductByIds(productIds);
        return ApiResult.success();
    }
}
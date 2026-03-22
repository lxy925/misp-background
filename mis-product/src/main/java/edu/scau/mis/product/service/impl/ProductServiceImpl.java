package edu.scau.mis.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.scau.mis.product.domain.Product;
import edu.scau.mis.product.domain.ProductQuery;
import edu.scau.mis.product.mapper.IProductMapper;
import edu.scau.mis.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductMapper productMapper;

    @Override
    public Product getProductById(Long productId) {
        return productMapper.selectProductById(productId);
    }

    @Override
    public Product getProductBySn(String productSn) {
        return productMapper.selectProductBySn(productSn);
    }

    @Override
    public List<Product> getProductList(Product product) {
        return productMapper.selectProductList(product);
    }

    @Override
    public PageInfo<Product> pageList(ProductQuery queryDto) {
        // 开启分页
        PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize());
        // 查询数据
        List<Product> list = productMapper.selectPageList(queryDto);
        // 封装成分页结果
        return new PageInfo<>(list);
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public int deleteProductById(Long productId) {
        return productMapper.deleteProductById(productId);
    }

    @Override
    public int deleteProductByIds(Long[] productIds) {
        return productMapper.deleteProductByIds(productIds);
    }
}
package edu.scau.mis.product.mapper;


import edu.scau.mis.product.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ICategoryMapper {
    /**
     * 根据ID查询产品分类
     * @param categoryId
     * @return
     */
    @Select("SELECT category_id,parent_id,category_name FROM pos_category WHERE category_id = #{categoryId}")
    Category selectCategoryById(Long categoryId);

    /**
     * 查询所有产品分类
     * @return
     */
    @Select("SELECT category_id,parent_id,category_name FROM pos_category")
    List<Category> selectAllCategoryList();
}

package edu.scau.mis.pos.mapper;

import edu.scau.mis.pos.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Mapper
@Primary
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

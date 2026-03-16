package edu.scau.mis.pos.mapper;

import edu.scau.mis.pos.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICategoryMapper {

    /**
     * 新增商品分类
     * @param category 分类信息
     * @return 结果
     */
    int insertCategory(Category category);

    /**
     * 根据分类ID查询分类
     * @param categoryId 分类ID
     * @return 分类信息
     */
    Category selectCategoryById(Long categoryId);

    /**
     * 条件查询分类列表（支持：categoryId、parentId、categoryName、level、state）
     * @param category 分类查询条件
     * @return 分类列表
     */
    List<Category> selectCategoryList(Category category);

    /**
     * 修改商品分类
     * @param category 分类信息
     * @return 结果
     */
    int updateCategory(Category category);

    /**
     * 根据ID删除商品分类
     * @param categoryId 分类ID
     * @return 结果
     */
    int deleteCategoryById(Long categoryId);

    /**
     * 批量删除商品分类
     * @param categoryIds 要删除的分类ID数组
     * @return 结果
     */
    int deleteCategoryByIds(@Param("array") Long[] categoryIds);
}
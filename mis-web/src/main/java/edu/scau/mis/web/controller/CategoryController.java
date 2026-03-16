package edu.scau.mis.web.controller;

import edu.scau.mis.common.web.domain.ApiResult;
import edu.scau.mis.pos.domain.Category;
import edu.scau.mis.pos.domain.CategoryTreeNode;
import edu.scau.mis.pos.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Tag(name = "商品类别管理")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 根据ID查询单个分类
     */
    @Operation(summary = "根据ID查询商品类别")
    @GetMapping("/{categoryId}")
    public ApiResult<Category> getById(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return category == null ? ApiResult.noContent() : ApiResult.success(category);
    }

    /**
     * 查询所有分类（不分层级）
     */
    @Operation(summary = "查询所有商品类别")
    @GetMapping("/listAll")
    public ApiResult<List<Category>> listAll() {
        List<Category> categories = categoryService.getAllCategories();
        return categories.isEmpty() ? ApiResult.noContent() : ApiResult.success(categories);
    }

    /**
     * 多条件组合查询分类
     * 支持：categoryId、parentId、categoryName、level、state
     */
    @Operation(summary = "条件查询商品类别")
    @GetMapping("/list")
    public ApiResult<List<Category>> list(Category category) {
        List<Category> list = categoryService.selectCategoryList(category);
        return ApiResult.success(list);
    }

    /**
     * 新增分类
     */
    @Operation(summary = "添加商品类别")
    @PostMapping("/add")
    public ApiResult add(@RequestBody Category category) {
        int rows = categoryService.insertCategory(category);
        return rows > 0 ? ApiResult.success("新增成功") : ApiResult.error("新增失败");
    }

    /**
     * 修改分类
     */
    @Operation(summary = "更编辑商品类别")
    @PutMapping("/update")
    public ApiResult update(@RequestBody Category category) {
        int rows = categoryService.updateCategory(category);
        return rows > 0 ? ApiResult.success("修改成功") : ApiResult.error("修改失败");
    }

    /**
     * 单条删除分类
     */
    @Operation(summary = "删除商品类别")
    @DeleteMapping("/delete/{categoryId}")
    public ApiResult delete(@PathVariable("categoryId") Long categoryId) {
        int rows = categoryService.deleteCategoryById(categoryId);
        return rows > 0 ? ApiResult.success("删除成功") : ApiResult.error("删除失败");
    }

    /**
     * 批量删除分类
     */
    @Operation(summary = "批量删除商品类别")
    @DeleteMapping("/batchDelete")
    public ApiResult batchDelete(@RequestBody Long[] categoryIds) {
        int rows = categoryService.deleteCategoryByIds(categoryIds);
        return rows > 0 ? ApiResult.success("批量删除成功") : ApiResult.error("批量删除失败");
    }

    /**
     * 获取分类树形结构（给前端树控件使用）
     */
    @Operation(summary = "获取类别树形结构")
    @GetMapping("/tree")
    public ApiResult<List<CategoryTreeNode>> getCategoriesTree() {
        return ApiResult.success(categoryService.getCategoriesTree());
    }
}
package edu.scau.mis.pos.mapper;

import edu.scau.mis.MisBootApplication;
import edu.scau.mis.pos.domain.Category;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)  // 是否回滚，设为false即会更新数据库，设为true则不会更新。
@ContextConfiguration(classes = MisBootApplication.class)
class ICategoryMapperTest {
    @Autowired
    private ICategoryMapper categoryMapper;

    @Test
    void selectCategoryById() {
        Category category = categoryMapper.selectCategoryById(1L);
        assertEquals("文具", category.getCategoryName());
    }

    @Test
    void selectAllCategoryList() {
        List<Category> categories = categoryMapper.selectAllCategoryList();
        assertEquals(3, categories.size());
    }
}
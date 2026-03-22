package edu.scau.mis.common;

import edu.scau.mis.common.oss.util.OssUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.io.FileInputStream;
import java.io.InputStream;

// 核心：指定扫描当前 common 模块
@SpringBootTest(classes = OssTest.TestApplication.class)
public class OssTest {

    // 启动类只扫描当前包，避免加载多余配置
    @SpringBootApplication(scanBasePackages = "edu.scau.mis.common")
    @TestPropertySource(locations = "classpath:application.yml")
    public static class TestApplication {}

    @Autowired
    private OssUtil ossUtil;

    @Test
    public void testUpload() throws Exception {
        String filePath = "D:\\svt\\svt香港\\IMG_20260228_180917.jpg";
        InputStream inputStream = new FileInputStream(filePath);

        String url = ossUtil.upload(inputStream, "test.jpg");
        System.out.println("✅ OSS 上传成功！地址：" + url);
    }
}
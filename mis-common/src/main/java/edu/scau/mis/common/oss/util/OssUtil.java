package edu.scau.mis.common.oss.util;

import com.aliyun.oss.OSS;
import edu.scau.mis.common.oss.config.OssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Component
public class OssUtil {

    // 注入配置类（统一管理配置，不再用@Value）
    @Autowired
    private OssProperties ossProperties;

    // 注入Spring管理的单例OSS客户端（不用每次new，性能更好）
    @Autowired
    private OSS ossClient;

    /**
     * 上传文件到阿里云OSS
     * @param inputStream 文件流
     * @param originalFilename 原始文件名
     * @return 可访问的文件URL
     */
    public String upload(InputStream inputStream, String originalFilename) {
        // 生成唯一文件名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 拼接文件存储路径（你可以自己修改目录）
        String fileKey = "upload/" + uuid + fileType;

        try {
            // 上传文件（使用单例OSS客户端）
            ossClient.putObject(ossProperties.getBucketName(), fileKey, inputStream);

            // 拼接返回URL
            return "https://" + ossProperties.getBucketName() + "." + ossProperties.getEndpoint() + "/" + fileKey;
        } finally {
            // 注意：单例Bean不需要shutdown！！！
            // 千万不要写 ossClient.shutdown()
        }
    }
    /**
     * 获取文件访问URL
     * @param objectName 文件对象名称
     * @return 可访问的文件URL
     */
    public String download(String objectName) {
        try {
            // 检查文件是否存在
            boolean exists = ossClient.doesObjectExist(ossProperties.getBucketName(), objectName);
            if (!exists) {
                throw new RuntimeException("文件不存在: " + objectName);
            }
            
            // 生成带签名的URL，有效期1小时
            Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
            URL url = ossClient.generatePresignedUrl(ossProperties.getBucketName(), objectName, expiration);
            return url.toString();
        } finally {
            // 注意：单例Bean不需要shutdown！！！
            // 千万不要写 ossClient.shutdown()
        }
    }
    /**
     * 删除文件
     * @param objectName 文件对象名称
     * @return 删除结果
     */
    public boolean delete(String objectName) {
        try {
            // 检查文件是否存在
            boolean exists = ossClient.doesObjectExist(ossProperties.getBucketName(), objectName);
            if (!exists) {
                throw new RuntimeException("文件不存在: " + objectName);
            }

            // 删除文件
            ossClient.deleteObject(ossProperties.getBucketName(), objectName);
            return true;
        } finally {
            // 注意：单例Bean不需要shutdown！！！
            // 千万不要写 ossClient.shutdown()
        }
    }
    
    /**
     * 从URL中提取文件对象名称
     * @param url OSS文件URL
     * @return 文件对象名称
     */
    public String extractObjectName(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        // 从URL中提取文件路径部分
        int index = url.indexOf("/", url.indexOf("//") + 2);
        if (index > 0) {
            return url.substring(index + 1);
        }
        return null;
    }


}
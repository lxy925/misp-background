package edu.scau.mis.common.controller;

import edu.scau.mis.common.oss.util.OssUtil;
import edu.scau.mis.common.web.domain.ApiResult;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/oss")
@Tag(name = "OSS上传管理")
public class OssController {
    @Autowired
    private OssUtil ossUtil;
    @Operation(summary = "上传文件")
    @PostMapping("/upload")
    public ApiResult<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        // 上传并返回URL
        String url = ossUtil.upload(file.getInputStream(), file.getOriginalFilename());
        return ApiResult.success(url);
    }

    @Operation(summary = "下载文件")
    @GetMapping("/download")
    public ApiResult<String> download(@RequestParam("objectName") String objectName) {
        // 获取文件访问URL
        String url = ossUtil.download(objectName);
        return ApiResult.success(url);
    }

    @Operation(summary = "删除文件")
    @DeleteMapping("/delete")
    public ApiResult<Void> delete(@RequestParam("objectName") String objectName) {
        // 删除文件
        ossUtil.delete(objectName);
        return ApiResult.success();
    }
}
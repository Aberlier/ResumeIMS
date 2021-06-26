package com.resumeims.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.server.feign
 * @InterfaceName: FeignByRequestMinioClassService
 * @date ：Created in 2021/6/25 8:17
 * @description：调用minio组件类
 * @modified By：
 * @version: v1.0.0$
 */

@FeignClient(url = "192.168.11.1:9981", name = "resume-config", configuration = FeignMultipartSupportConfig.class)
@Component
public interface FeignByRequestMinioClassService {
    @GetMapping("/getMinioConfig")
    String getMinioConfig();

    @PostMapping(value = "/putObjectUP", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    boolean putObjectUP(@RequestParam(value = "bucketName", required = false) String bucketName, @RequestParam(value = "objectName", required = false) String objectName, @RequestPart("file") MultipartFile file);

    @RequestMapping(value = "/upLoadFile")
    boolean upLoadFile(@RequestPart(value = "file",required = true) MultipartFile file);


    @PostMapping(value = "/putObject", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    boolean putObject(@RequestParam(value = "bucketName", required = false) String bucketName, @RequestParam(value = "objectName", required = false) String objectName, @RequestParam(value = "file") MultipartFile file);

    @PostMapping("/makeBucket")
    void makeBucket(@RequestParam(value = "bucketName", required = false) String bucketName);

    @PostMapping("/bucketExists")
    boolean bucketExists(@RequestParam(value = "bucketName", required = false) String bucketName);

    @RequestMapping(value = "/getObjectUrl", method = RequestMethod.GET)
    String getObjectUrl(@RequestParam(value = "bucketName", required = false) String bucketName, @RequestParam(value = "objectName", required = false) String objectName);
}

package com.resumeims.server;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.server
 * @InterfaceName: MinioFilesService
 * @date ：Created in 2021/6/24 15:57
 * @description：文件上传服务
 * @modified By：
 * @version: v1.0.0$
 */
public interface MinioFilesService {

//    /**
//     * 判断 bucket是否存在
//     *
//     * @param bucketName
//     * @return
//     */
//    boolean bucketExists(String bucketName);
//
//    /**
//     * 创建 bucket
//     *
//     * @param bucketName
//     */
//    void makeBucket(String bucketName);
//
//    /**
//     * 文件上传
//     *
//     * @param bucketName
//     * @param objectName
//     * @param filename
//     */
//    void putObject(String bucketName, String objectName, String filename);
//

    /**
     * 文件上传
     *
     * @param bucketName
     * @param objectName
     * @param file
     */
    boolean putObjectUP(String bucketName, String objectName, MultipartFile file);

    boolean upLoadFile(MultipartFile file);

    String getObjectUrl(String bucketName, String objectName);

//    /**
//     * 文件上传
//     *
//     * @param bucketName
//     * @param multipartFile
//     */
//    void putObject(String bucketName, MultipartFile multipartFile, String filename);

//    /**
//     * 删除文件
//     * @param bucketName
//     * @param objectName
//     */
//    boolean removeObject(String bucketName,String objectName);
//
//    /**
//     * 下载文件
//     *
//     * @param fileName
//     * @param originalName
//     * @param response
//     */
//    void downloadFile(String bucketName, String fileName, String originalName, HttpServletResponse response);
//
//    /**
//     * 获取文件路径
//     * @param bucketName
//     * @param objectName
//     * @return
//     */
//    String getObjectUrl(String bucketName,String objectName);
}

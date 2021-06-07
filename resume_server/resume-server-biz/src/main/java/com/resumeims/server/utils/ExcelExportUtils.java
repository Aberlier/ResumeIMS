package com.resumeims.server.utils;

/**
 * @author ：Angular
 * @ProjectName: zuihou-admin-cloud
 * @Package: com.cn.tanbao.eecp.utils
 * @ClassName: ExcelExportUtils
 * @date ：Created in 2021/4/27 9:19
 * @description：
 * @modified By：
 * @version: $
 */


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author gmd
 * @Description Excel导出方法
 */
@Component
public class ExcelExportUtils {
    /**
     * 模板路径处理，避免出现NPE
     * windows和linux系统不同，且SpringBoot的文件加载方式已有不同，不能简单的使用相对路径
     *
     * @param path excel模板的相对路径
     * @return 重写后的模板路径
     */
    public static String convertTemplatePath(String path) {
        // 如果是windows则直接返回
        if (System.getProperties().getProperty("os.name").contains("Windows")) {
            return path;
        }

        Resource resource = new ClassPathResource(path);
        FileOutputStream fileOutputStream = null;
        // 将模版文件写入到tomcat临时目录
        String folder = System.getProperty("catalina.home");
        File tempFile = new File(folder + File.separator + path);
        // 文件存在时不再写入
        if (tempFile.exists()) {
            return tempFile.getPath();
        }
        File parentFile = tempFile.getParentFile();
        // 判断父文件夹是否存在
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            BufferedInputStream inputStream = new BufferedInputStream(resource.getInputStream());
            fileOutputStream = new FileOutputStream(tempFile);
            byte[] buffer = new byte[10240];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tempFile.getPath();
    }

}
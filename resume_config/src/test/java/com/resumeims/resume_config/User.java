package com.resumeims.resume_config;

import lombok.Data;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: PACKAGE_NAME
 * @ClassName: User
 * @date ：Created in 2021/6/24 10:46
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class User {
    private String email;
    private String name;
    private String pwd;
    private String age;


    public User() {

    }
}

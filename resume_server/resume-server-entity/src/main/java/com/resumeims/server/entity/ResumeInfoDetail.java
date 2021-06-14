package com.resumeims.server.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.resumeims.resume_config.baseentity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_resume_info_detail")
@ApiModel(value = "ResumeInfoDetail", description = "个人信息介绍展示")
@AllArgsConstructor
public class ResumeInfoDetail extends Entity<Long> {

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    @Length(max = 50, message = "用户姓名长度不能超过50")
    @TableField(value = "user_name", condition = LIKE)
    @Excel(name = "用户姓名")
    private String userName;

    private String userPoliticalOutlook;

    private String userAge;

    private String userCity;

    private String userHometown;

    private String userUniversities;

    private String userEmail;

    private String userTelphone;

    private String userEducation;

    private Date userDateOfBirth;

    private String userExperience;

    private String userPictureUrlOne;

    private String userPictureUrlTwo;

    private String userPictureUrlThree;

    private String userPictureUrlFour;

    public ResumeInfoDetail(Long id, String userName, String userPoliticalOutlook, String userAge, String userCity, String userHometown, String userUniversities, String userEmail, String userTelphone, String userEducation, Date userDateOfBirth, String userExperience, String userPictureUrlOne, String userPictureUrlTwo, String userPictureUrlThree, String userPictureUrlFour, Long createUser, Long updateUser, Date createTime, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.userPoliticalOutlook = userPoliticalOutlook;
        this.userAge = userAge;
        this.userCity = userCity;
        this.userHometown = userHometown;
        this.userUniversities = userUniversities;
        this.userEmail = userEmail;
        this.userTelphone = userTelphone;
        this.userEducation = userEducation;
        this.userDateOfBirth = userDateOfBirth;
        this.userExperience = userExperience;
        this.userPictureUrlOne = userPictureUrlOne;
        this.userPictureUrlTwo = userPictureUrlTwo;
        this.userPictureUrlThree = userPictureUrlThree;
        this.userPictureUrlFour = userPictureUrlFour;
    }

}
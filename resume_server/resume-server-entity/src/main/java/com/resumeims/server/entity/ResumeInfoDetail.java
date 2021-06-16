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
    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "政治面貌")
    @Length(max = 50, message = "政治面貌长度不能超过50")
    @TableField(value = "user_political_outlook", condition = LIKE)
    @Excel(name = "政治面貌")
    private String userPoliticalOutlook;
    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "用户年龄")
    @Length(max = 50, message = "用户年龄长度不能超过50")
    @TableField(value = "user_political_outlook", condition = LIKE)
    @Excel(name = "用户年龄")
    private String userAge;
    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "现居城市")
    @Length(max = 50, message = "现居城市长度不能超过50")
    @TableField(value = "user_city", condition = LIKE)
    @Excel(name = "现居城市")
    private String userCity;

    /**
     * 故乡
     */
    @ApiModelProperty(value = "故乡")
    @Length(max = 50, message = "故乡长度不能超过50")
    @TableField(value = "user_hometown", condition = LIKE)
    @Excel(name = "故乡")
    private String userHometown;
    /**
     * 毕业院校
     */
    @ApiModelProperty(value = "毕业院校")
    @Length(max = 50, message = "毕业院校长度不能超过50")
    @TableField(value = "user_universities", condition = LIKE)
    @Excel(name = "毕业院校")
    private String userUniversities;
    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱")
    @Length(max = 50, message = "用户邮箱长度不能超过50")
    @TableField(value = "user_email", condition = LIKE)
    @Excel(name = "用户邮箱")
    private String userEmail;
    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    @Length(max = 50, message = "用户手机号长度不能超过50")
    @TableField(value = "user_telphone", condition = LIKE)
    @Excel(name = "用户手机号")
    private String userTelphone;
    /**
     * 学历
     */
    @ApiModelProperty(value = "学历")
    @Length(max = 50, message = "学历长度不能超过50")
    @TableField(value = "user_education", condition = LIKE)
    @Excel(name = "学历")
    private String userEducation;
    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    @Length(max = 50, message = "出生日期长度不能超过50")
    @TableField(value = "user_date_of_birth", condition = LIKE)
    @Excel(name = "出生日期")
    private Date userDateOfBirth;
    /**
     * 具备经验
     */
    @ApiModelProperty(value = "具备经验")
    @Length(max = 50, message = "具备经验长度不能超过50")
    @TableField(value = "user_experience", condition = LIKE)
    @Excel(name = "具备经验")
    private String userExperience;
    /**
     * 个人照片1
     */
    @ApiModelProperty(value = "个人照片1")
    @TableField(value = "user_picture_url_one", condition = LIKE)
    @Excel(name = "个人照片1")
    private String userPictureUrlOne;
    /**
     * 个人照片1
     */
    @ApiModelProperty(value = "个人照片2")
    @TableField(value = "user_picture_url_two", condition = LIKE)
    @Excel(name = "个人照片2")
    private String userPictureUrlTwo;
    /**
     * 个人照片1
     */
    @ApiModelProperty(value = "个人照片3")
    @TableField(value = "user_picture_url_three", condition = LIKE)
    @Excel(name = "个人照片3")
    private String userPictureUrlThree;
    /**
     * 个人照片4
     */
    @ApiModelProperty(value = "个人照片4")
    @TableField(value = "user_picture_url_four", condition = LIKE)
    @Excel(name = "个人照片4")
    private String userPictureUrlFour;
    @Builder
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
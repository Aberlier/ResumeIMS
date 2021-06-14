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

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_resume_index")
@ApiModel(value = "ResumeIndex", description = "工作经历")
@AllArgsConstructor
public class ResumeIndex extends Entity<Long> {

    /**
     * 头像名称
     */
    @ApiModelProperty(value = "头像名称")
    @Length(max = 50, message = "头像名称长度不能超过50")
    @TableField(value = "head_portrait", condition = LIKE)
    @Excel(name = "头像名称")
    private String headPortrait;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    @Length(max = 50, message = "头像地址长度不能超过50")
    @TableField(value = "head_portrait_url", condition = LIKE)
    @Excel(name = "头像地址")
    private String headPortraitUrl;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    @Length(max = 50, message = "用户名称长度不能超过50")
    @TableField(value = "user_name", condition = LIKE)
    @Excel(name = "用户名称")
    private String userName;

    /**
     * 用户签名
     */
    @ApiModelProperty(value = "用户签名")
    @Length(max = 50, message = "用户签名长度不能超过50")
    @TableField(value = "user_autograph", condition = LIKE)
    @Excel(name = "用户签名")
    private String userAutograph;
    /**
     * 用户背景图片
     */
    @ApiModelProperty(value = "用户背景图片")
    @Length(max = 50, message = "用户背景图片名称长度不能超过50")
    @TableField(value = "user_background", condition = LIKE)
    @Excel(name = "用户背景图片")
    private String userBackground;
    /**
     * 用户背景图片地址
     */
    @ApiModelProperty(value = "用户背景图片地址")
    @Length(max = 50, message = "用户背景图片地址长度不能超过50")
    @TableField(value = "user_background_url", condition = LIKE)
    @Excel(name = "用户背景图片地址")
    private String userBackgroundUrl;

    @Builder
    public ResumeIndex(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                            String headPortrait, String headPortraitUrl, String userName, String userAutograph, String userBackground,
                            String userBackgroundUrl) {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.headPortrait = headPortrait;
        this.headPortraitUrl = headPortraitUrl;
        this.userName = userName;
        this.userAutograph = userAutograph;
        this.userBackground = userBackground;
        this.userBackgroundUrl = userBackgroundUrl;
    }
}
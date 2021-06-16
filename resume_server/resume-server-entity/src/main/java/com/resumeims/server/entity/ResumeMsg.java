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
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_resume_msg")
@ApiModel(value = "ResumeMsg", description = "留言表")
@AllArgsConstructor
public class ResumeMsg extends Entity<Long> {
    /**
     * 姓名/企业
     */
    @ApiModelProperty(value = "姓名/企业")
    @Length(max = 50, message = "姓名/企业长度不能超过50")
    @TableField(value = "name", condition = LIKE)
    @Excel(name = "姓名/企业")
    private String name;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Length(max = 50, message = "邮箱长度不能超过50")
    @TableField(value = "email", condition = LIKE)
    @Excel(name = "邮箱")
    private String email;
    /**
     * IP地址
     */
    @ApiModelProperty(value = "IP地址")
    @Length(max = 50, message = "IP地址长度不能超过50")
    @TableField(value = "ip", condition = LIKE)
    @Excel(name = "IP地址")
    private String ip;
    /**
     * MAC地址
     */
    @ApiModelProperty(value = "MAC地址")
    @Length(max = 50, message = "MAC地址长度不能超过50")
    @TableField(value = "mac_address", condition = LIKE)
    @Excel(name = "MAC地址")
    private String macAddress;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    @Length(max = 50, message = "内容长度不能超过50")
    @TableField(value = "content", condition = LIKE)
    @Excel(name = "内容")
    private String content;

    @Builder
    public ResumeMsg(Long id, String name, String email, String ip, String macAddress, String content, Long createUser, Long updateUser, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ip = ip;
        this.macAddress = macAddress;
        this.content = content;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
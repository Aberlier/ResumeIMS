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
@TableName("t_resume_skills")
@ApiModel(value = "ResumeSkills", description = "技能表")
@AllArgsConstructor
public class ResumeSkills extends Entity<Long> {
    /**
     * 专业项目一
     */
    @ApiModelProperty(value = "专业项目一")
    @Length(max = 50, message = "专业项目一长度不能超过50")
    @TableField(value = "item_id", condition = LIKE)
    @Excel(name = "专业项目一")
    private String itemId;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @Length(max = 50, message = "标题长度不能超过50")
    @TableField(value = "title", condition = LIKE)
    @Excel(name = "标题")
    private String title;
    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    @Length(max = 50, message = "图片地址长度不能超过50")
    @TableField(value = "picture_url", condition = LIKE)
    @Excel(name = "图片地址")
    private String pictureUrl;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Length(max = 50, message = "描述长度不能超过900")
    @TableField(value = "desc", condition = LIKE)
    @Excel(name = "描述")
    private String desc;

    @Builder
    public ResumeSkills(Long id, String itemId, String title, String pictureUrl, String desc, Long createUser, Long updateUser, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.itemId = itemId;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.desc = desc;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
package com.resumeims.server.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.resumeims.resume_config.baseentity.Entity;
import com.resumeims.resume_config.baseentity.SuperEntity;
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
@TableName("t_resume_info")
@ApiModel(value = "ResumeInfo", description = "个人信息介绍展示")
@AllArgsConstructor
public class ResumeInfo extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @Length(max = 50, message = "标题长度不能超过50")
    @TableField(value = "title", condition = LIKE)
    @Excel(name = "标题")
    private String title;
    /**
     * 子标题
     */
    @ApiModelProperty(value = "子标题")
    @Length(max = 50, message = "子标题长度不能超过50")
    @TableField(value = "title_sub", condition = LIKE)
    @Excel(name = "子标题")
    private String titleSub;
    /**
     * 子标题内容
     */
    @ApiModelProperty(value = "子标题内容")
    @Length(max = 50, message = "子标题内容长度不能超过50")
    @TableField(value = "title_sub_content", condition = LIKE)
    @Excel(name = "子标题内容")
    private String titleSubContent;
    /**
     * 标题内容
     */
    @ApiModelProperty(value = "标题内容")
    @TableField(value = "title_content", condition = LIKE)
    @Excel(name = "标题内容")
    private String titleContent;

    @Builder
    public ResumeInfo(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                       String title, String titleSub, String titleSubContent, String titleContent) {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.title = title;
        this.titleSub = titleSub;
        this.titleSubContent = titleSubContent;
        this.titleContent = titleContent;
    }
}
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
@TableName("t_resume_study")
@ApiModel(value = "ResumeStudy", description = "求学经历表")
@AllArgsConstructor
public class ResumeStudy extends Entity<Long> {
    /**
     * 标题名称
     */
    @ApiModelProperty(value = "标题名称")
    @Length(max = 50, message = "标题名称长度不能超过50")
    @TableField(value = "title", condition = LIKE)
    @Excel(name = "标题名称")
    private String title;
    /**
     * 子标题名称
     */
    @ApiModelProperty(value = "子标题名称")
    @Length(max = 50, message = "子标题名称长度不能超过50")
    @TableField(value = "title_sub", condition = LIKE)
    @Excel(name = "子标题名称")
    private String titleSub;
    /**
     * 子标题副标题
     */
    @ApiModelProperty(value = "子标题副标题名称")
    @Length(max = 50, message = "子标题副标题名称长度不能超过50")
    @TableField(value = "title_sub_lite", condition = LIKE)
    @Excel(name = "子标题副标题名称")
    private String titleSubLite;
    /**
     * 时间开始节点
     */
    @ApiModelProperty(value = "时间开始节点")
    @Length(max = 50, message = "时间开始节点长度不能超过50")
    @TableField(value = "study_time_start", condition = LIKE)
    @Excel(name = "时间开始节点")
    private Date studyTimeStart;
    /**
     * 时间开始节点
     */
    @ApiModelProperty(value = "时间结束节点")
    @Length(max = 50, message = "时间结束节点长度不能超过50")
    @TableField(value = "study_time_end", condition = LIKE)
    @Excel(name = "时间结束节点")
    private Date studyTimeEnd;
    /**
     * 时间开始节点
     */
    @ApiModelProperty(value = "时间结束节点")
    @Length(max = 50, message = "时间结束节点长度不能超过50")
    @TableField(value = "study_time_end", condition = LIKE)
    @Excel(name = "时间结束节点")
    private String content;

    public ResumeStudy(Long id, String title, String titleSub, String titleSubLite, Date studyTimeStart, Date studyTimeEnd, Long createUser, Long updateUser, LocalDateTime createTime, LocalDateTime updateTime, String content) {
        this.id = id;
        this.title = title;
        this.titleSub = titleSub;
        this.titleSubLite = titleSubLite;
        this.studyTimeStart = studyTimeStart;
        this.studyTimeEnd = studyTimeEnd;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }
}
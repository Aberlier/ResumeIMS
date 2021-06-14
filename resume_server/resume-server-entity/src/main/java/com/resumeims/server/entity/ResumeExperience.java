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
@TableName("t_resume_experience")
@ApiModel(value = "ResumeExperience", description = "工作经历")
@AllArgsConstructor
public class ResumeExperience extends Entity<Long> {
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
     * 子标题副标题
     */
    @ApiModelProperty(value = "子标题副标题")
    @Length(max = 50, message = "子标题副标题长度不能超过50")
    @TableField(value = "title_sub_lite", condition = LIKE)
    @Excel(name = "子标题副标题")
    private String titleSubLite;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @Length(max = 50, message = "开始时间长度不能超过50")
    @TableField(value = "exp_time_start", condition = LIKE)
    @Excel(name = "开始时间")
    private LocalDateTime expTimeStart;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @Length(max = 50, message = "结束时间长度不能超过50")
    @TableField(value = "exp_time_end", condition = LIKE)
    @Excel(name = "结束时间")
    private LocalDateTime expTimeEnd;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    @Length(max = 50, message = "内容长度不能超过9999")
    @TableField(value = "content", condition = LIKE)
    @Excel(name = "内容")
    private String content;

    @Builder
    public ResumeExperience(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                            String content, LocalDateTime expTimeEnd, LocalDateTime expTimeStart, String titleSubLite, String titleSub,
                            String title) {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.content = content;
        this.expTimeEnd = expTimeEnd;
        this.expTimeStart = expTimeStart;
        this.titleSubLite = titleSubLite;
        this.titleSub = titleSub;
        this.title = title;
    }
}
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
@TableName("t_resume_experience")
@ApiModel(value = "ResumeStudyAndExperience", description = "工作经历")
@AllArgsConstructor
public class ResumeStudyAndExperience extends Entity<Long> {
    /**
     * 标题名称
     */
    @ApiModelProperty(value = "标题名称")
    @Length(max = 50, message = "标题名称长度不能超过50")
    @TableField(value = "title", condition = LIKE)
    @Excel(name = "标题名称")
    private String title;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Length(max = 50, message = "描述长度不能超过900")
    @TableField(value = "desc", condition = LIKE)
    @Excel(name = "描述")
    private String desc;

    @Builder
    public ResumeStudyAndExperience(Long id, String title, String desc, Long createUser, Long updateUser, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
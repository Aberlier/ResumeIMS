package com.resumeims.server.dto;

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

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "ResumeExperienceUpdateDTO", description = "工作经历修改")
public class ResumeExperienceUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @Length(max = 50, message = "标题长度不能超过50")
    private String title;

    /**
     * 子标题
     */
    @ApiModelProperty(value = "子标题")
    @Length(max = 50, message = "子标题长度不能超过50")
    private String titleSub;

    /**
     * 子标题副标题
     */
    @ApiModelProperty(value = "子标题副标题")
    @Length(max = 50, message = "子标题副标题长度不能超过50")
    private String titleSubLite;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @Length(max = 50, message = "开始时间长度不能超过50")
    private LocalDateTime expTimeStart;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @Length(max = 50, message = "结束时间长度不能超过50")
    private LocalDateTime expTimeEnd;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;
    
}
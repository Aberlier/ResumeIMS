package com.resumeims.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "ResumeExperiencePageDTO", description = "工作经历分页")
public class ResumeExperiencePageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

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
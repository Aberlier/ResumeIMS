package com.resumeims.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
public class ResumeTopUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 顶部标题
     */
    @ApiModelProperty(value = "顶部标题")
    @Length(max = 50, message = "顶部标题长度不能超过50")
    private String topTitle;
    /**
     * 第一个顶部标题
     */
    @ApiModelProperty(value = "第一个顶部标题")
    @Length(max = 50, message = "第一个顶部标题长度不能超过50")
    private String topFirstSubtitle;
    /**
     * 第二个顶部标题
     */
    @ApiModelProperty(value = "第二个顶部标题")
    @Length(max = 50, message = "第二个顶部标题长度不能超过50")
    private String topSecondSubtitle;
    /**
     * 第三个顶部标题
     */
    @ApiModelProperty(value = "第三个顶部标题")
    @Length(max = 50, message = "第三个顶部标题长度不能超过50")
    private String topThirdSubtitle;
    /**
     * 第四个顶部标题
     */
    @ApiModelProperty(value = "第四个顶部标题")
    @Length(max = 50, message = "第四个顶部标题长度不能超过50")
    private String topFourSubtitle;
    /**
     * 第五个顶部标题
     */
    @ApiModelProperty(value = "第五个顶部标题")
    @Length(max = 50, message = "第五个顶部标题长度不能超过50")
    private String topFiveSubtitle;
    /**
     * 第六个顶部标题
     */
    @ApiModelProperty(value = "第六个顶部标题")
    @Length(max = 50, message = "顶第六个顶部标题长度不能超过50")
    private String topSixSubtitle;
    /**
     * 第七个顶部标题
     */
    @ApiModelProperty(value = "第七个顶部标题")
    @Length(max = 50, message = "第七个顶部标题长度不能超过50")
    private String topSevenSubtitle;

}
package com.resumeims.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
public class ResumeStudySaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 头像名称
     */
    @ApiModelProperty(value = "头像名称")
    private String headPortrait;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String headPortraitUrl;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;

    /**
     * 用户签名
     */
    @ApiModelProperty(value = "用户签名")
    private String userAutograph;
    /**
     * 用户背景图片
     */
    @ApiModelProperty(value = "用户背景图片")
    private String userBackground;
    /**
     * 用户背景图片地址
     */
    @ApiModelProperty(value = "用户背景图片地址")
    private String userBackgroundUrl;

}
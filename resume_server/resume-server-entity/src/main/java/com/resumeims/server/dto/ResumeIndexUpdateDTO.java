package com.resumeims.server.dto;

import com.resumeims.resume_config.baseentity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
public class ResumeIndexUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;
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
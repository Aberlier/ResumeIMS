package com.resumeims.server.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.resumeims.resume_config.baseentity.SuperEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;


@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
public class ResumeInfoUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;
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
}
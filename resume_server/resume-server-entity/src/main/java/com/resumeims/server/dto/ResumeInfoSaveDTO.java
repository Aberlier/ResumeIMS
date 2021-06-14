package com.resumeims.server.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
public class ResumeInfoSaveDTO implements Serializable {
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
     * 子标题内容
     */
    @ApiModelProperty(value = "子标题内容")
    @Length(max = 50, message = "子标题内容长度不能超过50")
    private String titleSubContent;
    /**
     * 标题内容
     */
    @ApiModelProperty(value = "标题内容")
    private String titleContent;

}
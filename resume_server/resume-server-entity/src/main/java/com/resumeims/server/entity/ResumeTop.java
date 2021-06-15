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
@TableName("t_resume_top")
@ApiModel(value = "ResumeTop", description = "简历顶部")
@AllArgsConstructor
public class ResumeTop extends Entity<Long> {

    /**
     * 顶部标题
     */
    @ApiModelProperty(value = "顶部标题")
    @Length(max = 50, message = "顶部标题长度不能超过50")
    @TableField(value = "top_title", condition = LIKE)
    @Excel(name = "顶部标题")
    private String topTitle;
    /**
     * 第一个顶部标题
     */
    @ApiModelProperty(value = "第一个顶部标题")
    @Length(max = 50, message = "第一个顶部标题长度不能超过50")
    @TableField(value = "top_first_subtitle", condition = LIKE)
    @Excel(name = "第一个顶部标题")
    private String topFirstSubtitle;
    /**
     * 第二个顶部标题
     */
    @ApiModelProperty(value = "第二个顶部标题")
    @Length(max = 50, message = "第二个顶部标题长度不能超过50")
    @TableField(value = "top_second_subtitle", condition = LIKE)
    @Excel(name = "第二个顶部标题")
    private String topSecondSubtitle;
    /**
     * 第三个顶部标题
     */
    @ApiModelProperty(value = "第三个顶部标题")
    @Length(max = 50, message = "第三个顶部标题长度不能超过50")
    @TableField(value = "top_third_subtitle", condition = LIKE)
    @Excel(name = "第三个顶部标题")
    private String topThirdSubtitle;
    /**
     * 第四个顶部标题
     */
    @ApiModelProperty(value = "第四个顶部标题")
    @Length(max = 50, message = "第四个顶部标题长度不能超过50")
    @TableField(value = "top_four_subtitle", condition = LIKE)
    @Excel(name = "第四个顶部标题")
    private String topFourSubtitle;
    /**
     * 第五个顶部标题
     */
    @ApiModelProperty(value = "第五个顶部标题")
    @Length(max = 50, message = "第五个顶部标题长度不能超过50")
    @TableField(value = "top_five_subtitle", condition = LIKE)
    @Excel(name = "第五个顶部标题")
    private String topFiveSubtitle;
    /**
     * 第六个顶部标题
     */
    @ApiModelProperty(value = "第六个顶部标题")
    @Length(max = 50, message = "顶第六个顶部标题长度不能超过50")
    @TableField(value = "top_six_subtitle", condition = LIKE)
    @Excel(name = "第六个顶部标题")
    private String topSixSubtitle;
    /**
     * 第七个顶部标题
     */
    @ApiModelProperty(value = "第七个顶部标题")
    @Length(max = 50, message = "第七个顶部标题长度不能超过50")
    @TableField(value = "top_seven_subtitle", condition = LIKE)
    @Excel(name = "第七个顶部标题")
    private String topSevenSubtitle;


    @Builder
    public ResumeTop(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime, String topTitle, String topFirstSubtitle, String topSecondSubtitle, String topThirdSubtitle, String topFourSubtitle, String topFiveSubtitle, String topSixSubtitle, String topSevenSubtitle) {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.topTitle = topTitle;
        this.topFirstSubtitle = topFirstSubtitle;
        this.topSecondSubtitle = topSecondSubtitle;
        this.topThirdSubtitle = topThirdSubtitle;
        this.topFourSubtitle = topFourSubtitle;
        this.topFiveSubtitle = topFiveSubtitle;
        this.topSixSubtitle = topSixSubtitle;
        this.topSevenSubtitle = topSevenSubtitle;
    }

}
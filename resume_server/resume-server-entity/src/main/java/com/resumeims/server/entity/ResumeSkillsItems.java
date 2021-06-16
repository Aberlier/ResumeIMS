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
@TableName("t_resume_skills")
@ApiModel(value = "ResumeSkillsItems", description = "单项技能比例表")
@AllArgsConstructor
public class ResumeSkillsItems extends Entity<Long> {
    /**
     * 专业项目一
     */
    @ApiModelProperty(value = "专业项目一")
    @Length(max = 50, message = "专业项目一长度不能超过50")
    @TableField(value = "item_one", condition = LIKE)
    @Excel(name = "专业项目一")
    private String itemOne;
    /**
     * 专业项目一掌握程度
     */
    @ApiModelProperty(value = "专业项目一掌握程度")
    @Length(max = 50, message = "专业项目一掌握程度不能超过50")
    @TableField(value = "item_one_value", condition = LIKE)
    @Excel(name = "专业项目一掌握程度")
    private String itemOneValue;
    /**
     * 专业项目二掌握程度
     */
    @ApiModelProperty(value = "专业项目二掌握程度")
    @Length(max = 50, message = "专业项目二掌握程度不能超过50")
    @TableField(value = "item_one_value", condition = LIKE)
    @Excel(name = "专业项目二掌握程度")
    private String itemTwo;
    /**
     * 专业项目二掌握程度
     */
    @ApiModelProperty(value = "专业项目二掌握程度")
    @Length(max = 50, message = "专业项目二掌握程度不能超过50")
    @TableField(value = "item_one_value", condition = LIKE)
    @Excel(name = "专业项目二掌握程度")
    private String itemTwoValue;
    /**
     * 专业项目三
     */
    @ApiModelProperty(value = "专业项目三")
    @Length(max = 50, message = "专业项目三不能超过50")
    @TableField(value = "item_third", condition = LIKE)
    @Excel(name = "专业项目三")
    private String itemThrid;
    /**
     * 专业项目三掌握程度
     */
    @ApiModelProperty(value = "专业项目三掌握程度")
    @Length(max = 50, message = "专业项目三掌握程度不能超过50")
    @TableField(value = "item_third_value", condition = LIKE)
    @Excel(name = "专业项目三掌握程度")
    private String itemThridValue;
    /**
     * 专业项目四
     */
    @ApiModelProperty(value = "专业项目四")
    @Length(max = 50, message = "专业项目四长度不能超过50")
    @TableField(value = "item_four", condition = LIKE)
    @Excel(name = "专业项目四")
    private String itemFour;
    /**
     * 专业项目四掌握程度
     */
    @ApiModelProperty(value = "专业项目四掌握程度")
    @Length(max = 50, message = "专业项目四掌握程度不能超过50")
    @TableField(value = "item_four_value", condition = LIKE)
    @Excel(name = "专业项目四掌握程度")
    private String itemFourValue;
    /**
     * 专业项目五
     */
    @ApiModelProperty(value = "专业项目五")
    @Length(max = 50, message = "专业项目五长度不能超过50")
    @TableField(value = "item_five", condition = LIKE)
    @Excel(name = "专业项目五")
    private String itemFive;
    /**
     * 专业项目五掌握程度
     */
    @ApiModelProperty(value = "专业项目五掌握程度")
    @Length(max = 50, message = "专业项目五掌握程度不能超过50")
    @TableField(value = "item_five_value", condition = LIKE)
    @Excel(name = "专业项目五掌握程度")
    private String itemFiveValue;
    /**
     * 专业项目六
     */
    @ApiModelProperty(value = "专业项目六")
    @Length(max = 50, message = "专业项目六长度不能超过50")
    @TableField(value = "item_six", condition = LIKE)
    @Excel(name = "专业项目六")
    private String itemSix;
    /**
     * 专业项目六掌握程度
     */
    @ApiModelProperty(value = "专业项目六掌握程度")
    @Length(max = 50, message = "专业项目六掌握程度不能超过50")
    @TableField(value = "item_six_value", condition = LIKE)
    @Excel(name = "专业项目六掌握程度")
    private String itemSixValue;

    @Builder
    public ResumeSkillsItems(Long id,String itemOne, String itemOneValue, String itemTwo, String itemTwoValue, String itemThrid, String itemThridValue, String itemFour, String itemFourValue, String itemFive, String itemFiveValue, String itemSix, String itemSixValue, Long createUser, Long updateUser, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.itemOne = itemOne;
        this.itemOneValue = itemOneValue;
        this.itemTwo = itemTwo;
        this.itemTwoValue = itemTwoValue;
        this.itemThrid = itemThrid;
        this.itemThridValue = itemThridValue;
        this.itemFour = itemFour;
        this.itemFourValue = itemFourValue;
        this.itemFive = itemFive;
        this.itemFiveValue = itemFiveValue;
        this.itemSix = itemSix;
        this.itemSixValue = itemSixValue;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
package com.resumeims.server.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.resumeims.resume_config.baseentity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import static com.resumeims.resume_config.utils.DateUtils.DEFAULT_DATE_TIME_FORMAT;

/**
 * <p>
 * 实体类
 * 应急物资入库
 * </p>
 *
 * @author tanbao
 * @since 2020-11-10
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)

@ApiModel(value = "EmergencyMaterialInputEntity", description = "应急物资入库列表")
@AllArgsConstructor
public class EmergencyMaterialInputEntity extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 物资编码
     */
    @ApiModelProperty(value = "物资编码")
    @Length(max = 50, message = "物资编码长度不能超过50")
    @TableField(value = "material_code", condition = LIKE)
    @Excel(name = "物资编码")
    private String materialCode;
    /**
     * 物资名称
     */
    @ApiModelProperty(value = "物资名称")
    @Length(max = 100, message = "物资名称长度不能超过100")
    @TableField(value = "material_name", condition = LIKE)
    @Excel(name = "物资名称")
    private String materialName;

    /**
     * 物资类型
     */
    @ApiModelProperty(value = "物资类型")
    @Length(max = 50, message = "物资类型长度不能超过50")
    @TableField(value = "material_type", condition = LIKE)
    @Excel(name = "物资类型")
    private String materialType;
    /**
     * 所在位置
     */
    @ApiModelProperty(value = "所在位置")
    @Length(max = 50, message = "所在位置长度不能超过50")
    @TableField(value = "facility_infor", condition = LIKE)
    @Excel(name = "所在位置")
    private String facilityInfor;

    /**
     * 物资数量
     */
    @ApiModelProperty(value = "物资数量")
    @TableField("material_count")
    @Excel(name = "物资数量")
    private Integer materialCount;

    /**
     * 标准数量
     */
    @ApiModelProperty(value = "标准数量")
    @TableField("material_stand_count")
    @Excel(name = "标准数量")
    private Integer materialStandCount;

    /**
     * 入库时间
     */
    @ApiModelProperty(value = "入库时间")
    @TableField("input_time")
    @Excel(name = "入库时间", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDateTime inputTime;

    /**
     * 存放位置
     */
    @ApiModelProperty(value = "存放位置")
    @Excel(name = "存放位置")
    @TableField("material_address")
    private String materialAddress;

    /**
     * 存放有效期
     */
    @ApiModelProperty(value = "存放有效期")
    @TableField("validity_date")
    @Excel(name = "存放有效期", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDate validityDate;


    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    @Length(max = 50, message = "负责人编码长度不能超过50")
    @TableField(value = "manager", condition = LIKE)
    @Excel(name = "负责人")
    private String manager;

    @TableField(value = "manager_code", condition = LIKE)
    @Excel(name = "负责人编码")
    private String managerCode;

    @TableField(value = "material_unit", condition = LIKE)
    @Excel(name = "单位")
    private String materialUnit;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    @Length(max = 50, message = "联系方式长度不能超过50")
    @TableField(value = "contact_infor", condition = LIKE)
    @Excel(name = "联系方式")
    private String contactInfor;


}

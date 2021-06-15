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
@TableName("emergency_material_input")
@ApiModel(value = "EmergencyMaterialInput", description = "应急物资入库")
@AllArgsConstructor
public class EmergencyMaterialInput extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 场所编码
     */
    @ApiModelProperty(value = "场所编码")
    @Length(max = 50, message = "场所编码长度不能超过50")
    @TableField(value = "facility_code", condition = LIKE)
    @Excel(name = "场所编码")
    private String facilityCode;

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
     * 物资数量
     */
    @ApiModelProperty(value = "物资数量",example = "0")
    @TableField("material_count")
    @Excel(name = "物资数量")
    private Integer materialCount;

    /**
     * 标准数量
     */
    @ApiModelProperty(value = "标准数量",example = "0")
    @TableField("material_stand_count")
    @Excel(name = "标准数量")
    private Integer materialStandCount;

    /**
     * 物资单位
     */
    @ApiModelProperty(value = "物资单位")
    @Length(max = 50, message = "物资单位长度不能超过50")
    @TableField(value = "material_unit", condition = LIKE)
    @Excel(name = "物资单位")
    private String materialUnit;

    /**
     * 存放日期
     */
    @ApiModelProperty(value = "存放日期")
    @TableField("storage_time")
    @Excel(name = "存放日期", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDateTime storageTime;

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
     * 出厂厂家
     */
    @ApiModelProperty(value = "出厂厂家")
    @Length(max = 100, message = "出厂厂家长度不能超过100")
    @TableField(value = "manufacturer", condition = LIKE)
    @Excel(name = "出厂厂家")
    private String manufacturer;

    /**
     * 厂家电话
     */
    @ApiModelProperty(value = "厂家电话")
    @Length(max = 50, message = "厂家电话长度不能超过50")
    @TableField(value = "phone_number", condition = LIKE)
    @Excel(name = "厂家电话")
    private String phoneNumber;

    /**
     * 物资用途
     */
    @ApiModelProperty(value = "物资用途")

    @TableField("material_usage")
    @Excel(name = "物资用途")
    private String materialUsage;

    /**
     * 负责人编码
     */
    @ApiModelProperty(value = "负责人编码")
    @Length(max = 50, message = "负责人编码长度不能超过50")
    @TableField(value = "manager_code", condition = LIKE)
    @Excel(name = "负责人编码")
    private String managerCode;

    /**
     * 入库人
     */
    @ApiModelProperty(value = "入库人")
    @Length(max = 50, message = "入库人长度不能超过50")
    @TableField(value = "input_manager", condition = LIKE)
    @Excel(name = "入库人")
    private String inputManager;

    /**
     * 入库时间
     */
    @ApiModelProperty(value = "入库时间")
    @TableField("input_time")
    @Excel(name = "入库时间", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDateTime inputTime;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    @Length(max = 10, message = "是否启用长度不能超过10")
    @TableField(value = "status", condition = LIKE)
    @Excel(name = "是否启用")
    private String status;


    @Builder
    public EmergencyMaterialInput(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                                  String facilityCode, String materialCode, String materialName, String materialType, Integer materialCount,
                                  String materialUnit, LocalDateTime storageTime, LocalDate validityDate, String manufacturer, String phoneNumber, String materialUsage,
                                  String managerCode, String inputManager, LocalDateTime inputTime, String status) {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.facilityCode = facilityCode;
        this.materialCode = materialCode;
        this.materialName = materialName;
        this.materialType = materialType;
        this.materialCount = materialCount;
        this.materialUnit = materialUnit;
        this.storageTime = storageTime;
        this.validityDate = validityDate;
        this.manufacturer = manufacturer;
        this.phoneNumber = phoneNumber;
        this.materialUsage = materialUsage;
        this.managerCode = managerCode;
        this.inputManager = inputManager;
        this.inputTime = inputTime;
        this.status = status;
    }

}

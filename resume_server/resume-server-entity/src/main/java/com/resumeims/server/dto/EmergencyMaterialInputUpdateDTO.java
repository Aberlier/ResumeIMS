package com.resumeims.server.dto;

import com.github.zuihou.base.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "EmergencyMaterialInputUpdateDTO", description = "应急物资入库")
public class EmergencyMaterialInputUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 场所编码
     */
    @ApiModelProperty(value = "场所编码")
    @Length(max = 50, message = "场所编码长度不能超过50")
    private String facilityCode;
    /**
     * 物资编码
     */
    @ApiModelProperty(value = "物资编码")
    @Length(max = 50, message = "物资编码长度不能超过50")
    private String materialCode;
    /**
     * 物资名称
     */
    @ApiModelProperty(value = "物资名称")
    @Length(max = 100, message = "物资名称长度不能超过100")
    private String materialName;
    /**
     * 物资类型
     */
    @ApiModelProperty(value = "物资类型")
    @Length(max = 50, message = "物资类型长度不能超过50")
    private String materialType;
    /**
     * 物资数量
     */
    @ApiModelProperty(value = "物资数量")
    private Integer materialCount;

    /**
     * 标准数量
     */
    @ApiModelProperty(value = "标准数量")
    private Integer materialStandCount;
    /**
     * 物资单位
     */
    @ApiModelProperty(value = "物资单位")
    @Length(max = 50, message = "物资单位长度不能超过50")
    private String materialUnit;
    /**
     * 存放日期
     */
    @ApiModelProperty(value = "存放日期")
    private LocalDateTime storageTime;
    /**
     * 存放位置
     */
    @ApiModelProperty(value = "存放位置")
    private String materialAddress;
    /**
     * 存放有效期
     */
    @ApiModelProperty(value = "存放有效期")
    private LocalDate validityDate;
    /**
     * 出厂厂家
     */
    @ApiModelProperty(value = "出厂厂家")
    @Length(max = 100, message = "出厂厂家长度不能超过100")
    private String manufacturer;
    /**
     * 厂家电话
     */
    @ApiModelProperty(value = "厂家电话")
    @Length(max = 50, message = "厂家电话长度不能超过50")
    private String phoneNumber;
    /**
     * 物资用途
     */
    @ApiModelProperty(value = "物资用途")
    private String materialUsage;
    /**
     * 负责人编码
     */
    @ApiModelProperty(value = "负责人编码")
    @Length(max = 50, message = "负责人编码长度不能超过50")
    private String managerCode;
    /**
     * 入库人
     */
    @ApiModelProperty(value = "入库人")
    @Length(max = 50, message = "入库人长度不能超过50")
    private String inputManager;
    /**
     * 入库时间
     */
    @ApiModelProperty(value = "入库时间")
    private LocalDateTime inputTime;
    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    @Length(max = 10, message = "是否启用长度不能超过10")
    private String status;
}

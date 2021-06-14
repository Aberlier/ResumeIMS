package com.resumeims.server.controller;

import com.resumeims.resume_config.basecontroller.SuperController;
import com.resumeims.server.ResumeStudyService;
import com.resumeims.server.dto.ResumeStudyPageDTO;
import com.resumeims.server.dto.ResumeStudySaveDTO;
import com.resumeims.server.dto.ResumeStudyUpdateDTO;
import com.resumeims.server.entity.ResumeStudy;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.server.controller
 * @ClassName: ResumeStudyController
 * @date ：Created in 2021/6/13 23:00
 * @description：简历主页信息控制层
 * @modified By：
 * @version: v1.0.0$
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/resumeStudyController")
@Api(value = "ResumeStudyController", tags = "简历主页信息控制层")
public class ResumeStudyController extends SuperController<ResumeStudyService, Long,ResumeStudy, ResumeStudyPageDTO, ResumeStudySaveDTO, ResumeStudyUpdateDTO> {
    @Autowired
    private ResumeStudyService resumeStudyService;

    /**
     * Excel导入后的操作
     *
     * @param list
     */
/*    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list) {
        List<> emergencyMaterialInputList = list.stream().map((map) -> {
            EmergencyMaterialInput emergencyMaterialInput = EmergencyMaterialInput.builder().build();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            emergencyMaterialInput.setFacilityCode(map.get("场所编码"));
            emergencyMaterialInput.setInputManager(map.get("入库人"));
            emergencyMaterialInput.setInputTime(LocalDateTime.parse(map.get("入库时间"), df));
            emergencyMaterialInput.setManagerCode(map.get("负责人编码"));
            emergencyMaterialInput.setManufacturer(map.get("出厂厂家"));
            emergencyMaterialInput.setMaterialCode(map.get("物资编码"));
            emergencyMaterialInput.setMaterialCount(Integer.parseInt(map.get("物资数量")));
            emergencyMaterialInput.setMaterialStandCount(Integer.parseInt(map.get("标准数量")));
            emergencyMaterialInput.setMaterialName(map.get("物资名称"));
            emergencyMaterialInput.setMaterialType(map.get("物资类型"));
            emergencyMaterialInput.setMaterialUnit(map.get("物资单位"));
            emergencyMaterialInput.setMaterialUsage(map.get("物资用途"));
            emergencyMaterialInput.setPhoneNumber(map.get("厂家电话"));
            emergencyMaterialInput.setStatus(map.get("是否启用"));
            emergencyMaterialInput.setStorageTime(LocalDateTime.parse(map.get("存放日期"), df));
            emergencyMaterialInput.setValidityDate(LocalDate.parse(map.get("存放有效期"), df));
            //TODO 请在这里完成转换
            return emergencyMaterialInput;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(emergencyMaterialInputList));
    }*/

}

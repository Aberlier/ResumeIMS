package com.resumeims.server;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.resume_config.baseservices.SuperService;
import com.resumeims.server.dto.EmergencyMaterialInputSaveDTO;
import com.resumeims.server.entity.EmergencyMaterialInput;
import com.resumeims.server.entity.EmergencyMaterialInputEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务接口
 * 应急物资入库
 * </p>
 *
 * @author tanbao
 * @date 2020-11-10
 */
public interface EmergencyMaterialInputService extends SuperService<EmergencyMaterialInput> {
    List<Map<String, Object>> populationIndexInfo();

    List<Map<String, Object>> rescueIndexInfo();

    List<Map<String, Object>> rescueTotalInfo();

    List<Map<String, Object>> rescueLevelTypeInfo();

    List<Map<String, Object>> materialQuantityInfo();

    Map<String, Object> materialTypeInfo();

    List<Map<String, Object>> materialTypePositionInfo();

    Map<String, Object> shelterTypeInfo();

    List<Map<String, Object>> teamQuantityInfo();

    Map<String, Object> teamIndustryInfo();

    List<Map<String, Object>> teamTypeInfo();

    List<Map<String, Object>> teamAgeInfo();

    List<Map<String, Object>> expertQuantityInfo();

    Map<String, Object> expertEducationInfo();

    List<Map<String, Object>> expertTypeLevelInfo();

    Page materialInputPageInfo(Map<String, Object> params);

    List<EmergencyMaterialInputEntity> materialInputListInfo(Map<String, Object> params);

    void emergencyMaterialInputExcel(List<EmergencyMaterialInputEntity> populationIndexInfo, HttpServletRequest request, HttpServletResponse response);

    void downloadModel(Map params, HttpServletRequest request, HttpServletResponse response);

    void upload(List<EmergencyMaterialInputEntity> factors, EmergencyMaterialInputSaveDTO dto);
}

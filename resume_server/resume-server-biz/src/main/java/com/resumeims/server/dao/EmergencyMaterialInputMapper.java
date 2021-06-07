package com.resumeims.server.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.EmergencyMaterialInput;
import com.resumeims.server.entity.EmergencyMaterialInputEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * 应急物资入库
 * </p>
 *
 * @author tanbao
 * @date 2020-11-10
 */
@Repository
public interface EmergencyMaterialInputMapper extends SuperMapper<EmergencyMaterialInput> {
    List<Map<String, Object>> populationIndexInfo();

    List<Map<String, Object>> rescueIndexInfo();

    List<Map<String, Object>> rescueTotalInfo();

    List<Map<String, Object>> rescueLevelTypeInfo(@Param("typeList") List<String> typeList, @Param("levelList") List<String> levelList);

    List<Map<String, Object>> materialQuantityInfo();

    List<Map<String, Object>> materialTypeInfo();

    List<Map<String, Object>> materialTypePositionInfo();

    List<Map<String, Object>> shelterTypeInfo();

    Map<String, Object> shelterTypeInfoTop();

    List<Map<String, Object>> teamQuantityInfo();

    List<Map<String, Object>> teamIndustryInfo();

    Map<String, Object> teamIndustryInfoTop();

    String teamScaleInfoTop();

    List<Map<String, Object>> teamTypeInfo();

    List<Map<String, Object>> teamAgeInfo();

    List<Map<String, Object>> expertQuantityInfo();

    List<Map<String, Object>> expertEducationInfo();

    Map<String, Object> expertEducationInfoTop();

    List<Map<String, Object>> expertTypeLevelInfo();

    List<EmergencyMaterialInputEntity> materialInputPageInfo(IPage page, @Param("params") Map<String, Object> params);

    List<EmergencyMaterialInputEntity> materialInputListInfo(@Param("params") Map<String, Object> params);

    List<Map<String, String>> rescueValue(@Param("type") String type);

    List<Map<String, Object>> selectManagerCode();
}

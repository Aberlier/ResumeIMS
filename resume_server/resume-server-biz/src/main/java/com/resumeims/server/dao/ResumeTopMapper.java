package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.EmergencyMaterialInput;
import com.resumeims.server.entity.ResumeTop;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeTopMapper extends SuperMapper<ResumeTop> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeTop record);

    int insertSelective(ResumeTop record);

    ResumeTop selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeTop record);

    int updateByPrimaryKey(ResumeTop record);
}
package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeStudyAndExperience;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeStudyAndExperienceMapper extends SuperMapper<ResumeStudyAndExperience> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeStudyAndExperience record);

    int insertSelective(ResumeStudyAndExperience record);

    ResumeStudyAndExperience selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeStudyAndExperience record);

    int updateByPrimaryKey(ResumeStudyAndExperience record);
}
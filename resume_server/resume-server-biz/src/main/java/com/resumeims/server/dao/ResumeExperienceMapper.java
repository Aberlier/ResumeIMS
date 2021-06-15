package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeExperience;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeExperienceMapper extends SuperMapper<ResumeExperience> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeExperience record);

    int insertSelective(ResumeExperience record);

    ResumeExperience selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeExperience record);


    int updateByPrimaryKey(ResumeExperience record);
}
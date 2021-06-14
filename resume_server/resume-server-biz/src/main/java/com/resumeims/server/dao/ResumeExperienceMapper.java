package com.resumeims.server.dao;

import com.resumeims.server.entity.ResumeExperience;

public interface ResumeExperienceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeExperience record);

    int insertSelective(ResumeExperience record);

    ResumeExperience selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeExperience record);

    int updateByPrimaryKeyWithBLOBs(ResumeExperience record);

    int updateByPrimaryKey(ResumeExperience record);
}
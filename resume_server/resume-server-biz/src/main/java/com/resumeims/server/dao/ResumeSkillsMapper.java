package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeSkills;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeSkillsMapper extends SuperMapper<ResumeSkills> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeSkills record);

    int insertSelective(ResumeSkills record);

    ResumeSkills selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeSkills record);

    int updateByPrimaryKey(ResumeSkills record);
}
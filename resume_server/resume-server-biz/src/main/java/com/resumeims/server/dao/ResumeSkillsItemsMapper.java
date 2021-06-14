package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeSkillsItems;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeSkillsItemsMapper extends SuperMapper<ResumeSkillsItems> {
    int deleteByPrimaryKey(Long itemId);

    int insert(ResumeSkillsItems record);

    int insertSelective(ResumeSkillsItems record);

    ResumeSkillsItems selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(ResumeSkillsItems record);

    int updateByPrimaryKey(ResumeSkillsItems record);
}
package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeIndex;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeIndexMapper extends SuperMapper<ResumeIndex> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeIndex record);

    int insertSelective(ResumeIndex record);

    ResumeIndex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeIndex record);

    int updateByPrimaryKey(ResumeIndex record);
}
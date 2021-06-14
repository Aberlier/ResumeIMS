package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeStudy;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeStudyMapper extends SuperMapper<ResumeStudy> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeStudy record);

    int insertSelective(ResumeStudy record);

    ResumeStudy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeStudy record);

    int updateByPrimaryKeyWithBLOBs(ResumeStudy record);

    int updateByPrimaryKey(ResumeStudy record);
}
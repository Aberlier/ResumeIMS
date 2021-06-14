package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeInfoDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeInfoDetailMapper extends SuperMapper<ResumeInfoDetail> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeInfoDetail record);

    int insertSelective(ResumeInfoDetail record);

    ResumeInfoDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeInfoDetail record);

    int updateByPrimaryKey(ResumeInfoDetail record);
}
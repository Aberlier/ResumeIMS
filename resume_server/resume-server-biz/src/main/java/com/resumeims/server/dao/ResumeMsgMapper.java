package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeMsg;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeMsgMapper extends SuperMapper<ResumeMsg> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeMsg record);

    int insertSelective(ResumeMsg record);

    ResumeMsg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeMsg record);

    int updateByPrimaryKey(ResumeMsg record);
}
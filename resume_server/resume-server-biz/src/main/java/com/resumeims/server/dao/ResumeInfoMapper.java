package com.resumeims.server.dao;

import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeInfoMapper extends SuperMapper<ResumeInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeInfo record);

    int insertSelective(ResumeInfo record);

    ResumeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeInfo record);

    int updateByPrimaryKey(ResumeInfo record);
}
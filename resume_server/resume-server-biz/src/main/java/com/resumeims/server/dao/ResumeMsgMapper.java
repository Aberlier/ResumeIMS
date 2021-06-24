package com.resumeims.server.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.server.entity.ResumeMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ResumeMsgMapper extends SuperMapper<ResumeMsg> {
    int deleteByPrimaryKey(Long id);

    int insert(ResumeMsg record);

    int insertSelective(ResumeMsg record);

    ResumeMsg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResumeMsg record);

    int updateByPrimaryKey(ResumeMsg record);



    List<Map> msgList(@Param("params") Map<String, Object> params);

    List<Map> msgPage(Page<Map> page, Map<String, Object> params);
}
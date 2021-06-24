package com.resumeims.server.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.resume_config.utils.CustomQuery;
import com.resumeims.server.ResumeMsgService;
import com.resumeims.server.dao.ResumeMsgMapper;
import com.resumeims.server.entity.ResumeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务接口
 * 顶部
 * </p>
 *
 * @author zjc
 * @date 2021-06-14
 */
@Slf4j
@Service
public class ResumeMsgServiceImpl extends SuperServiceImpl<ResumeMsgMapper, ResumeMsg> implements ResumeMsgService {

    @Override
    public Page msgPage(Map<String, Object> params) {
        Page<Map> page = new CustomQuery<Map>(params).getPage();
        page.setOptimizeCountSql(false);
        List<Map> msgPage = baseMapper.msgPage(page,params);
        return page.setRecords(msgPage);
    }

    @Override
    public List<Map> msgList(Map<String, Object> params) {
        return baseMapper.msgList(params);
    }
}

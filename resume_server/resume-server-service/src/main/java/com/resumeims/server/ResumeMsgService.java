package com.resumeims.server;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.resume_config.baseservices.SuperService;
import com.resumeims.server.entity.ResumeMsg;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务接口
 * 应急物资入库
 * </p>
 *
 * @author tanbao
 * @date 2020-11-10
 */
public interface ResumeMsgService extends SuperService<ResumeMsg> {

    Page msgPage(Map<String, Object> params);

    List<Map> msgList(Map<String, Object> params);
}

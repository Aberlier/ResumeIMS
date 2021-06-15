package com.resumeims.server.impl;

import com.resumeims.server.ResumeIndexService;
import com.resumeims.server.dao.ResumeIndexMapper;
import com.resumeims.server.entity.ResumeIndex;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务接口
 * 主页
 * </p>
 *
 * @author zjc
 * @date 2021-06-14
 */
@Slf4j
@Service
public class ResumeIndexServiceImpl extends SuperServiceImpl<ResumeIndexMapper, ResumeIndex> implements ResumeIndexService {
}

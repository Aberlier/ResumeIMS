package com.resumeims.server.impl;

import com.resumeims.server.ResumeIndexService;
import com.resumeims.server.ResumeTopService;
import com.resumeims.server.dao.ResumeIndexMapper;
import com.resumeims.server.dao.ResumeTopMapper;
import com.resumeims.server.entity.ResumeIndex;
import com.resumeims.server.entity.ResumeTop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class ResumeTopServiceImpl extends SuperServiceImpl<ResumeTopMapper, ResumeTop> implements ResumeTopService {

}

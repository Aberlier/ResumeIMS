package com.resumeims.server.impl;

import com.resumeims.server.ResumeInfoService;
import com.resumeims.server.dao.ResumeInfoMapper;
import com.resumeims.server.entity.ResumeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class ResumeInfoServiceImpl extends SuperServiceImpl<ResumeInfoMapper, ResumeInfo> implements ResumeInfoService {

}

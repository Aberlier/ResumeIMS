package com.resumeims.server.impl;

import com.resumeims.server.ResumeExperienceService;
import com.resumeims.server.dao.ResumeExperienceMapper;
import com.resumeims.server.entity.ResumeExperience;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.server.impl
 * @ClassName: ResumeExperienceServiceImpl
 * @date ：Created in 2021/6/14 10:30
 * @description：工作经历
 * @modified By：
 * @version: v1.0.0$
 */
@Slf4j
@Service
public class ResumeExperienceServiceImpl extends SuperServiceImpl<ResumeExperienceMapper, ResumeExperience> implements ResumeExperienceService {
}

package com.resumeims.server.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.resume_config.baseservices.SuperService;
import com.resumeims.server.EmergencyMaterialInputService;
import com.resumeims.server.ResumeIndexService;
import com.resumeims.server.dao.EmergencyMaterialInputMapper;
import com.resumeims.server.dao.ResumeIndexMapper;
import com.resumeims.server.dto.EmergencyMaterialInputSaveDTO;
import com.resumeims.server.entity.EmergencyMaterialInput;
import com.resumeims.server.entity.EmergencyMaterialInputEntity;
import com.resumeims.server.entity.ResumeIndex;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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

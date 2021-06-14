package com.resumeims.server;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resumeims.resume_config.baseservices.SuperService;
import com.resumeims.server.dto.EmergencyMaterialInputSaveDTO;
import com.resumeims.server.entity.EmergencyMaterialInput;
import com.resumeims.server.entity.EmergencyMaterialInputEntity;
import com.resumeims.server.entity.ResumeIndex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public interface ResumeIndexService extends SuperService<ResumeIndex> {

}

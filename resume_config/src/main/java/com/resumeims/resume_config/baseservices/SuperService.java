package com.resumeims.resume_config.baseservices;

/**
 * @author ：Angular
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.server.base
 * @InterfaceName: SuperService
 * @date ：Created in 2021/6/6 11:51
 * @description：基础业务逻辑层
 * @modified By：
 * @version: v1.0.0$
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.resumeims.resume_config.basemapper.SuperMapper;
import com.resumeims.resume_config.exceptionconfig.BizException;
import com.resumeims.resume_config.exceptionconfig.ExceptionCode;

import java.util.List;

/**
 * 基于MP的 IService 新增了2个方法： saveBatchSomeColumn、updateAllById
 * 其中：
 * 1，updateAllById 执行后，会清除缓存
 * 2，saveBatchSomeColumn 批量插入
 *
 * @param <T> 实体
 * @author zuihuo
 * @date 2020年03月03日20:49:03
 */
public interface SuperService<T> extends IService<T> {
    /**
     * 获取实体的类型
     *
     * @return
     */
    Class<T> getEntityClass();

    /**
     * 批量保存数据
     * <p>
     * 注意：该方法仅仅测试过mysql
     *
     * @param entityList
     * @return
     */
    default boolean saveBatchSomeColumn(List<T> entityList) {
        if (entityList.isEmpty()) {
            return true;
        }
        if (entityList.size() > 5000) {
            throw BizException.wrap(ExceptionCode.TOO_MUCH_DATA_ERROR);
        }
        return SqlHelper.retBool(((SuperMapper) getBaseMapper()).insertBatchSomeColumn(entityList));
    }

    /**
     * 根据id修改 entity 的所有字段
     *
     * @param entity
     * @return
     */
    boolean updateAllById(T entity);

}


package com.resumeims.resume_config.exceptionconfig;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.resume_config.ExceptionConfig
 * @InterfaceName: BaseException
 * @date ：Created in 2021/6/6 11:58
 * @description：基础错误类
 * @modified By：
 * @version: v1.0.0$
 */
public interface BaseException {

    /**
     * 统一参数验证异常码
     */
    int BASE_VALID_PARAM = -9;

    /**
     * 返回异常信息
     *
     * @return
     */
    String getMessage();

    /**
     * 返回异常编码
     *
     * @return
     */
    int getCode();

}


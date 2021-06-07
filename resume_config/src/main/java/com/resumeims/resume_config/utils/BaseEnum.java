package com.resumeims.resume_config.utils;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.util.Arrays;
import java.util.Map;

import static org.springframework.boot.ansi.AnsiOutput.toString;

/**
 * 枚举类型基类
 *
 * @author zuihou
 * @date 2019/07/26
 */
public interface BaseEnum extends IEnum<String> {
    /**
     * 将制定的枚举集合转成 map
     * key -> name
     * value -> desc
     *
     * @param list
     * @return
     */
    static Map<String, String> getMap(BaseEnum[] list) {
        return MapHelper.uniqueIndex(Arrays.asList(list), BaseEnum::getCode, BaseEnum::getDesc);
    }

    /**
     * 编码重写
     *
     * @return
     */
    default String getCode() {
        return toString();
    }

    /**
     * 描述
     *
     * @return
     */
    String getDesc();

    /**
     * 判断val是否跟当前枚举相等
     *
     * @param val
     * @return
     */
    default boolean eq(String val) {
        return this.getCode().equalsIgnoreCase(val);
    }

    /**
     * 枚举值
     *
     * @return
     */
    @Override
    default String getValue() {
        return getCode();
    }
}

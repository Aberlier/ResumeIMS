/*
 *
 */
package com.resumeims.resume_config.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author fxw
 */
public class CustomQuery<T> extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    private static final String ASC = "asc";

    public CustomQuery(Map<String, Object> params) {

        String strPage = "page";
        String strLimit = "limit";
        this.putAll(params);

        //分页参数
        if (params.get(strPage) != null) {
            currPage = Integer.parseInt(params.get("page").toString());
        }
        if (params.get(strLimit) != null) {
            limit = Integer.parseInt(params.get("limit").toString());
        }

        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);

        String sidx = (String) params.get("sidx");
        //默认升序
        Boolean asc = true;
        if (!isNullOrEmpty(params.get(ASC))) {
            asc = (Boolean) params.get("asc");
        }
        //mybatis-plus分页
        this.page = new Page<>(currPage, limit);

        //排序
        if (StringUtils.isNotBlank(sidx)) {
            if (asc) {
                this.page.setAsc(sidx);
            } else {
                this.page.setDesc(sidx);
            }
        }

    }

    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }


    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }

        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }

        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (Object anObject : object) {
                if (!isNullOrEmpty(anObject)) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }
}

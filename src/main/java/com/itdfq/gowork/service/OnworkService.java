package com.itdfq.gowork.service;

import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.model.Onwork;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
public interface OnworkService {


    /**
     * 新增
     *
     * @param onwork
     */
    void insert(Onwork onwork);

    Onwork findByUsername(String username);
}
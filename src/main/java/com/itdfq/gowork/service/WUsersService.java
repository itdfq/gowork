package com.itdfq.gowork.service;

import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.model.WUsers;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
public interface WUsersService {
    /**
     * 通过username查询单个
     *
     * @param username
     * @return {@link WUsers}
     */
    WUsers findByUsername(String username);



}
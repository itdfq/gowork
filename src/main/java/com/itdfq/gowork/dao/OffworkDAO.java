package com.itdfq.gowork.dao;

import com.github.pagehelper.Page;
import com.itdfq.gowork.model.Offwork;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
public interface OffworkDAO {
    /**
     * 新增
     *
     * @param offwork
     */
    @Insert("insert into offwork(offtime,username,password) values(#{offtime},#{username},#{password})")
    void insert(Offwork offwork);



}
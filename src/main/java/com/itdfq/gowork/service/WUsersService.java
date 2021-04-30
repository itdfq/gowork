package com.itdfq.gowork.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.model.WUsers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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



    /**
     * 通过用户账号查询单个
     *
     * @param username
     * @return {@link WUsers}
     */


    Page<WUsers> findByTj(WUsers username);

    /**
     * 分页查询
     *
     * @return {@link WUsers}
     */
    Page<WUsers> findByPage();

    /**
     * 新增
     *
     * @param wUsers
     */
    void insert(WUsers wUsers);

    /**
     * 修改
     *
     * @param wUsers
     */
    void update(WUsers wUsers);

    /**
     * 通过ID删除单个
     *
     *
     */
    void deleteById(WUsers wUsers);


    void deleteSelect(List<String> list);
}
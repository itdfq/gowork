package com.itdfq.gowork.dao;

import com.github.pagehelper.Page;
import com.itdfq.gowork.model.WUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Mapper
public interface WUsersDAO {

    /**
     * 通过username查询单个
     *
     * @param username
     * @return {@link WUsers}
     */
    @Select("select * from w_users where username = #{username}")
    WUsers findByUsername(String username);

    /**
     * 通过ID查询单个
     *
     * @param id ID
     * @return {@link WUsers}
     */
    WUsers findById(Integer id);

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
     * @param id ID
     */
    void deleteById(Integer id);

}
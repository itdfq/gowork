package com.itdfq.gowork.dao;

import com.github.pagehelper.Page;
import com.itdfq.gowork.model.WUsers;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
     * 通过用户账号查询单个
     *
     * @param username
     * @return {@link WUsers}
     */

    @Select({"<script>",
            "SELECT * FROM w_users",
            "WHERE 1=1",
            "<when test='username!=null'>",
            "and username like concat('%',#{username},'%')",
            "</when>",
            "</script>"})
    Page<WUsers> findByTj(WUsers username);

    /**
     * 分页查询
     *
     * @return {@link WUsers}
     */
    @Select("select * from w_users")
    Page<WUsers> findByPage();

    /**
     * 新增
     *
     * @param wUsers
     */
    @Insert("insert into w_users(`rename`,username,password,role) values(#{rename},#{username},#{password},#{role})")
    void insert(WUsers wUsers);

    /**
     * 修改
     *
     * @param wUsers
     */
    @Update("update w_users set `rename`=#{rename},username = #{username},password = #{password},role=#{role} where id = #{id}")
    void update(WUsers wUsers);

    /**
     * 通过ID删除单个
     *
     *
     */
    @Delete("delete from w_users where id = #{id}")
    void deleteById(WUsers wUsers);

    //多选删除
    @Delete({"<script>" +
            " delete from  w_users  where id  in "+
            "<foreach collection='list' item='custId' open='(' close=')' separator=','> #{custId}</foreach> "+
            " </script>"})
    void deleteSelect(List<String> custId);
}
package com.itdfq.gowork.dao;


import com.itdfq.gowork.model.Onwork;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
public interface OnworkDAO {

    /**
     * 新增
     * @param onwork
     */
    @Insert("insert into onwork(ontime,username,password) values(#{ontime},#{username},#{password})")
    void insert(Onwork onwork);

    @Select("select * from onwork where username = #{username}")
    Onwork findByusername(String username);

}
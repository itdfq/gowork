package com.itdfq.gowork.dao;


import com.itdfq.gowork.model.Sum;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author GocChin
 * @Date 2021/4/30 19:02
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
public interface SumDAO {

    @Select("select * from qiandao")
    List<Sum> findByPage();


    @Select({"<script>",
        "SELECT * FROM qiandao",
        "WHERE 1=1",
        "<when test='realname!=null'>",
        "and realname like concat('%',#{realname},'%')",
        "</when>",
        "<when test='starttime!=null'>",
        "and nowdate  >= #{starttime}",
        "</when>",
        "<when test='endtime!=null'>",
        "and  #{endtime} >= nowdate",
        "</when>",
        "</script>"})
    List<Sum> findByTJ(Sum sum);

    //签到
    @Insert("insert into qiandao(realname,username,ontime,onmark,nowdate) values(#{realname},#{username},#{ontime},#{onmark},#{nowdate})")
    void qiandao(Sum sum);
    //签退
    @Update("update qiandao set offtime=#{offtime},offmark=#{offmark} where nowdate=#{nowdate} ")
    void qiantui(Sum sum);

    //查询今天是否签到过
    @Select("select * from qiandao where nowdate=#{nowdate} and username=#{username}")
    Sum findByNowDay(Sum sum);

}

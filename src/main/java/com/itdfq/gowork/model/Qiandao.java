package com.itdfq.gowork.model;

import lombok.Data;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Data
public class Qiandao {
    /**
     *
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String realname;
    /**
     * 当前日期
     */
    private String nowday;
    /**
     *
     */
    private String 签到状态;
    /**
     * 用户账号
     */
    private String username;
}
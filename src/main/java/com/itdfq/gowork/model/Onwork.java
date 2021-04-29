package com.itdfq.gowork.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Data
public class Onwork {
    /**
     *
     */
    private Integer id;


    /**
     * 签到时间
     */
    private String ontime;
    /**
     * 签到账号
     */
    private String username;
    private String password;
}
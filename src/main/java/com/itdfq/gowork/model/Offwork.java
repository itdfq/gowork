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
public class Offwork {
    /**
     *
     */
    private Integer id;
    /**
     * 签退时间
     */
    private String offtime;
    /**
     * 签退账号
     */
    private String username;

    private String password;
}
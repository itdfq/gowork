package com.itdfq.gowork.model;

import lombok.Data;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Data
public class WUsers {
    /**
     * 唯一id
     */
    private Integer id;
    /**
     *
     */
    private String rename;
    /**
     *
     */
    private String username;
    /**
     *
     */
    private String password;
    /**
     * 1管理员2普通用户
     */
    private Integer role;
}
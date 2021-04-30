package com.itdfq.gowork.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author GocChin
 * @Date 2021/4/30 18:58
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
//签到数据总表
@Data
public class Sum {
    private  String id;
    private String username;
    //数据库中并没有，只是为了传递参数
    private String password;
    //真实姓名
    private String realname;
    //签到时间
    private String ontime;
    //签到状态
    private String onmark;
    //签退时间
    private String offtime;
    //签退状态
    private String offmark;
    //当天日期
    private String nowdate;
    //数据库中并没有只是为了接受
    private String starttime;
    //数据库中并没有只是为了接受
    private String endtime;

}

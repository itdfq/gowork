package com.itdfq.gowork.controller;


import com.itdfq.gowork.model.Onwork;
import com.itdfq.gowork.model.WUsers;
import com.itdfq.gowork.service.OnworkService;
import com.itdfq.gowork.service.WUsersService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@CrossOrigin
@RestController
@RequestMapping("/onworks")
@Api(tags = "签到")
public class OnworkController {

    @Autowired
    private OnworkService onworkService;

    @Autowired
    private WUsersService wUsersService;

    private Map<String,Object> map = new HashMap<>();

    @RequestMapping("/insert")
    public Map<String,Object> insert(@RequestBody Onwork onwork)  {
        System.out.println(onwork);
        map.clear();
        WUsers byUsername = wUsersService.findByUsername(onwork.getUsername());
        if (byUsername == null){
            map.put("msg","用户不存在");
        }else{
            if (byUsername.getPassword().equals(onwork.getPassword())){
                try {
                    onworkService.insert(onwork);
                    map.put("msg",1);
                } catch (Exception e) {
                    e.printStackTrace();
                    map.put("msg",e.getMessage());
                }
            }else{
                map.put("msg","密码错误");
            }
        }
        return map;
    }
}

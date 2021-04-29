package com.itdfq.gowork.controller;


import com.itdfq.gowork.model.Offwork;
import com.itdfq.gowork.model.Onwork;
import com.itdfq.gowork.model.WUsers;
import com.itdfq.gowork.service.OffworkService;
import com.itdfq.gowork.service.OnworkService;
import com.itdfq.gowork.service.WUsersService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/offworks")
@Api(tags = "签退")
public class OffworkController {

    @Autowired
    private OffworkService offworkService;

    @Autowired
    private WUsersService wUsersService;

    private Map<String,Object> map = new HashMap<>();

    @RequestMapping("/insert")
    public Map<String,Object> insert(@RequestBody Offwork offwork){
        System.out.println(offwork);
        map.clear();
        WUsers byUsername = wUsersService.findByUsername(offwork.getUsername());
        if (byUsername == null){
            map.put("msg","用户不存在");
        }else{
            if (byUsername.getPassword().equals(offwork.getPassword())){
                try {
                    offworkService.insert(offwork);
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

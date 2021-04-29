package com.itdfq.gowork.controller;

import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.model.WUsers;
import com.itdfq.gowork.service.WUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@RestController
@RequestMapping("/wUserss")
@Api(tags = "")
public class WUsersController {
    @Autowired
    private WUsersService wUsersService;

    private Map<String,Object> map = new HashMap<>();

    @RequestMapping("/login")
    @ApiOperation("登录功能")
    public Map<String,Object> login(@RequestBody WUsers wUsers, HttpServletRequest request){
        map.clear();
        WUsers byUsername = wUsersService.findByUsername(wUsers.getUsername());
        if (byUsername==null){
            map.put("msg","用户不存在");
        }else {
            if (byUsername.getPassword().equals(wUsers.getPassword())){
                try {
                    if (byUsername.getRole().equals(1)){
                        map.put("msg",1);
                        request.getSession().setAttribute("user",byUsername);
                    }else{
                        map.put("msg","对不起，您不是管理员");
                    }
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

    @RequestMapping("/findByUser")
    public Map<String,Object> findByUser(HttpSession session){
        try {
            WUsers user = (WUsers) session.getAttribute("user");
            if (user==null){
                map.put("msg","用户登录异常，请重新登录");
                return map;
            }else {
                map.put("msg",1);
                return map;
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }



}

package com.itdfq.gowork.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.dao.SumDAO;
import com.itdfq.gowork.model.Sum;
import com.itdfq.gowork.model.WUsers;
import com.itdfq.gowork.service.SumService;
import com.itdfq.gowork.service.WUsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.Oneway;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author GocChin
 * @Date 2021/4/30 19:35
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@RestController
@RequestMapping("/sum")
public class SumController {
    @Autowired
    private SumService service;

    @Autowired
    private WUsersService wUsersService;

    private Map<String,Object> map = new HashMap<>();
    @RequestMapping("/findByPage")
    public Map<String,Object> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer page,
                                         @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer limit){
        map.clear();
        PageHelper.startPage(page,limit);
        try {
            List<Sum> byPage = service.findByPage();
            PageInfo<Sum> pageInfo = new PageInfo<>(byPage);
            map.put("count",pageInfo.getTotal());
            map.put("data",pageInfo.getList());
            map.put("code",0);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/findByTJ")
    public Map<String,Object> findByYJ(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer page,
                                       @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer limit, @RequestBody Sum sum){
        map.clear();
        PageHelper.startPage(page,limit);
        System.out.println(sum);
        try {
            List<Sum> byPage = service.findByTJ(sum);
            PageInfo<Sum> pageInfo = new PageInfo<>(byPage);
            map.put("count",pageInfo.getTotal());
            map.put("data",pageInfo.getList());
            map.put("code",0);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/qiantui")
    @ApiOperation("签退")
    public Map<String,Object> deleteById(@RequestBody Sum sum) {
        try {
            WUsers byUsername = wUsersService.findByUsername(sum.getUsername());
            if (byUsername!=null) {
                if (byUsername.getPassword().equals(sum.getPassword())){
                    service.qiantui(sum);
                    map.put("msg",1);
                }else {
                    map.put("msg","密码错误");
                }
            }else {
                map.put("msg","用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/qiandao")
    @ApiOperation("签到")
    public Map<String,Object> qiandao(@RequestBody Sum sum) {
        try {
            WUsers byUsername = wUsersService.findByUsername(sum.getUsername());
            if (byUsername!=null){
                if (byUsername.getPassword().equals(sum.getPassword())){
                    Sum byNowDay = service.findByNowDay(sum);
                    if (byNowDay==null){
                        sum.setRealname(byUsername.getRename());
                        System.out.println(sum);
                        service.qiandao(sum);
                        map.put("msg",1);
                    }else {
                        map.put("msg","今天已经签到过了");
                        return map;
                    }
                }else {
                    map.put("msg","密码错误");
                    return map;
                }

            }else{
                map.put("msg","用户不存在");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }




}

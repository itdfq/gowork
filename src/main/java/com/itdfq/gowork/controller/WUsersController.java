package com.itdfq.gowork.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.model.Sum;
import com.itdfq.gowork.model.WUsers;
import com.itdfq.gowork.service.WUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    //检查用户是否登录
    @RequestMapping("/findByUser")
    public Map<String,Object> findByUser(HttpSession session){
        try {
            WUsers user = (WUsers) session.getAttribute("user");
            if (user==null){
                map.put("msg","用户登录异常，请重新登录");
                return map;
            }else {
                map.put("msg",1);
                map.put("role",user.getRole());
                return map;
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/findByPage")
    //分页查询
    public Map<String,Object> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer page,
                                         @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer limit){
        map.clear();
        PageHelper.startPage(page,limit);
        try {
            List<WUsers> byPage = wUsersService.findByPage();
            PageInfo<WUsers> pageInfo = new PageInfo<>(byPage);
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

    //分页条件查询
    @RequestMapping("/findByTJ")
    public Map<String,Object> findByPageTJ(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer page,
                                         @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer limit,@RequestBody WUsers wUsers ){
        map.clear();
        PageHelper.startPage(page,limit);
        try {
            List<WUsers> byPage = wUsersService.findByTj(wUsers);
            PageInfo<WUsers> pageInfo = new PageInfo<>(byPage);
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
    @PostMapping("/insert")
    @ApiOperation("新增")
    public Map<String,Object> insert(@RequestBody WUsers wUsers) {
        map.clear();
        try {
            wUsersService.insert(wUsers);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("mas",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/update")
    @ApiOperation("修改")
    public Map<String,Object> update(@RequestBody WUsers wUsers) {
        System.out.println(wUsers);
        map.clear();
        try {
            wUsersService.update(wUsers);
            map.put("msg",1);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/delete")
    @ApiOperation("通过ID删除单个")
    public Map<String,Object> deleteById(@RequestBody WUsers wUsers) {
        try {
            wUsersService.deleteById(wUsers);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

    //    批量删除
    @RequestMapping("/deleteSelect")
    public Map<String,Object> deleteSelect(String id){
        map.clear();
        try {
            List<String> list = new ArrayList<>();
            String[] strs = id.split(",");
            for (String str : strs) {
                list.add(str);
            }
            wUsersService.deleteSelect(list);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }



}

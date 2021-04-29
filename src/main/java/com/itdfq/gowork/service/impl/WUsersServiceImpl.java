package com.itdfq.gowork.service.impl;


import com.itdfq.gowork.dao.WUsersDAO;
import com.itdfq.gowork.model.WUsers;
import com.itdfq.gowork.service.WUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Author GocChin
 * @Date 2021/4/29 10:47
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Service
public class WUsersServiceImpl implements WUsersService {

    @Autowired
    private WUsersDAO wUsersDAO;

    @Override
    public WUsers findByUsername(String username) {
        return wUsersDAO.findByUsername(username);
    }


}

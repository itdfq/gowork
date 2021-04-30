package com.itdfq.gowork.service.impl;


import com.github.pagehelper.Page;
import com.itdfq.gowork.dao.WUsersDAO;
import com.itdfq.gowork.model.WUsers;
import com.itdfq.gowork.service.WUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public Page<WUsers> findByTj(WUsers wUsers) {
        return wUsersDAO.findByTj(wUsers);
    }

    @Override
    public Page<WUsers> findByPage() {
        return wUsersDAO.findByPage();
    }

    @Override
    public void insert(WUsers wUsers) {
        wUsersDAO.insert(wUsers);
    }

    @Override
    public void update(WUsers wUsers) {
        wUsersDAO.update(wUsers);
    }

    @Override
    public void deleteById(WUsers wUsers) {
        wUsersDAO.deleteById(wUsers);
    }

    @Override
    public void deleteSelect(List<String> list) {
        wUsersDAO.deleteSelect(list);
    }


}

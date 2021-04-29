package com.itdfq.gowork.service.impl;

import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.dao.OnworkDAO;
import com.itdfq.gowork.model.Onwork;
import com.itdfq.gowork.service.OnworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author GocChin
 * @Date 2021/4/29 11:46
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Service
public class OnworkServiceImpl implements OnworkService {

    @Autowired
    private OnworkDAO onworkDAO;



    @Override
    public void insert(Onwork onwork) {
            onworkDAO.insert(onwork);
    }

    @Override
    public Onwork findByUsername(String username) {
        return onworkDAO.findByusername(username);
    }


}

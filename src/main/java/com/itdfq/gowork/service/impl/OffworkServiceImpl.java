package com.itdfq.gowork.service.impl;

import com.itdfq.gowork.dao.OffworkDAO;
import com.itdfq.gowork.model.Offwork;
import com.itdfq.gowork.service.OffworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author GocChin
 * @Date 2021/4/29 13:18
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Service
public class OffworkServiceImpl implements OffworkService {
    @Autowired
    private OffworkDAO offworkDAO;

    @Override
    public void insert(Offwork offwork) {
       offworkDAO.insert(offwork);
    }
}

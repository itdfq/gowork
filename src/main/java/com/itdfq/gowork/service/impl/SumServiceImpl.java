package com.itdfq.gowork.service.impl;


import com.itdfq.gowork.dao.SumDAO;
import com.itdfq.gowork.model.Sum;
import com.itdfq.gowork.service.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author GocChin
 * @Date 2021/4/30 19:35
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Service
public class SumServiceImpl implements SumService {

    @Autowired
    private SumDAO sumDAO;

    @Override
    public List<Sum> findByPage() {
        return sumDAO.findByPage();
    }

    @Override
    public List<Sum> findByTJ(Sum sum) {
        return sumDAO.findByTJ(sum);
    }

    @Override
    public void qiandao(Sum sum) {
        sumDAO.qiandao(sum);
    }

    @Override
    public void qiantui(Sum sum) {
        sumDAO.qiantui(sum);
    }

    @Override
    public Sum findByNowDay(Sum sum) {
        return sumDAO.findByNowDay(sum);
    }

}

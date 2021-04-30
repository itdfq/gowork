package com.itdfq.gowork.service;

import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.model.Sum;

import java.util.List;

/**
 * @Author GocChin
 * @Date 2021/4/30 19:34
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
public interface SumService {
    List<Sum>  findByPage();

    List<Sum> findByTJ(Sum sum);

    void qiandao(Sum sum);

    void qiantui(Sum sum);

    Sum findByNowDay(Sum sum);
}

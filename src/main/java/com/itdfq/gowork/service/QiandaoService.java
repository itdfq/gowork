package com.itdfq.gowork.service;

import com.github.pagehelper.PageInfo;
import com.itdfq.gowork.model.Qiandao;

/**
 * @Author GocChin
 * @Date 2021/4/29
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
public interface QiandaoService {

    /**
     * 通过ID查询单个
     *
     * @param id ID
     * @return {@link Qiandao}
     */
    Qiandao findById(Integer id);

    /**
     * 分页查询
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link Qiandao}
     */
    PageInfo<Qiandao> findByPage(int pageNum, int pageSize);

    /**
     * 新增
     *
     * @param qiandao
     */
    void insert(Qiandao qiandao);

    /**
     * 修改
     *
     * @param qiandao
     */
    void update(Qiandao qiandao);

    /**
     * 通过ID删除单个
     *
     * @param id ID
     */
    void deleteById(Integer id);

}
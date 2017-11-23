package com.skyhuang.study.program.cost.service;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.program.cost.dao.CostDao;
import com.skyhuang.study.program.cost.domain.Cost;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/11/22.
 */
public class CostService {

    private CostDao  costDao = new CostDao();

    public List<Cost> selectAll(WebPager pager) throws SQLException {
        return  costDao.selectAll(pager);
    }

    public int insert(Cost cost) throws SQLException {
        return costDao.insert(cost);
    }

    public Cost selectById(int id) throws SQLException {
        return costDao.selectById(id);
    }
}

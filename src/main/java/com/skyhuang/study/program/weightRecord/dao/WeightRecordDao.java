package com.skyhuang.study.program.weightRecord.dao;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.program.weightRecord.domain.WeightRecord;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/9/25.
 */
public interface WeightRecordDao {
    //查询
    public List<WeightRecord> selectAll(WebPager pager) throws SQLException;
    //根据id查询
    public WeightRecord selectById(int id) throws SQLException;
    //新增
    public void insert(WeightRecord weightRecord) throws SQLException;
    //修改
    public void updataById(WeightRecord weightRecord) throws SQLException;
    //删除

}

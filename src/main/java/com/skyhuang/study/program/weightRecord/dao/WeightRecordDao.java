package com.skyhuang.study.program.weightRecord.dao;

import com.skyhuang.study.program.weightRecord.domain.WeightRecord;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/9/25.
 */
public interface WeightRecordDao {
    //查询
    public List<WeightRecord> selectAll() throws SQLException;
    //新增
    public void insert(WeightRecord weightRecord) throws SQLException;
    //修改
    //删除

}

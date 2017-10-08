package com.skyhuang.study.program.weightRecord.service;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.program.weightRecord.dao.WeightRecordDao;
import com.skyhuang.study.program.weightRecord.dao.WeightRecordDaoImpl;
import com.skyhuang.study.program.weightRecord.domain.User;
import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/9/25.
 */
public class WeightRecordService {

    private WeightRecordDao weightRecordDao = new WeightRecordDaoImpl();

    public void insert(WeightRecord weightRecord) throws SQLException {
        weightRecordDao.insert(weightRecord);
    }

    public List<WeightRecord> selectAll(WebPager pager) throws SQLException {
        return weightRecordDao.selectAll(pager);
    }

    public WeightRecord selectById(int id) throws SQLException {
        return weightRecordDao.selectById(id);
    }

    public void updateById(WeightRecord weightRecord) throws SQLException {
        weightRecordDao.updataById(weightRecord);
    }

    public User selectUserByUsernameAndPassword(User user) throws SQLException {
       return weightRecordDao.selectUserByUsernameAndPassword(user);
    }
}

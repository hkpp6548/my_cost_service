package com.skyhuang.study.program.weightRecord.dao;

import com.skyhuang.study.jdbc.DataSourceUtils;
import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hk on 2017/9/25.
 */
public class WeightRecordDaoImpl implements WeightRecordDao {
    public List<WeightRecord> selectAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String selectAllSql = "select * from weight_record";
        List<WeightRecord> list = queryRunner.query(selectAllSql, new BeanListHandler<WeightRecord>(WeightRecord.class));
        for (WeightRecord wr: list) {
            System.out.println(wr);
        }
        return list;
    }

    public void insert(WeightRecord wr) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String insertSql = "insert into weight_record(id, date, run_ago_weight, run_after_weight, bath_after_weight, " +
                "sleep_ago_weight, is_run) values (null,?,?,?,?,?,?)";
        queryRunner.update(insertSql, wr.getDate(), wr.getRunAgoWeight(),
                wr.getRunAfterWeight(), wr.getBathAfterWeight(), wr.getSleepAgoWeight(), wr.getIsRun());
    }
}

package com.skyhuang.study.program.weightRecord.dao;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.jdbc.DataSourceUtils;
import com.skyhuang.study.program.weightRecord.domain.User;
import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hk on 2017/9/25.
 */
public class WeightRecordDaoImpl implements WeightRecordDao {

    /** 查询所有体重记录 */
    private static final String FS_SQL_SELECT = "SELECT * FROM weight_record ";
    /** order by */
    private static final String FS_SQL_ORDERBY = " ORDER BY ";
    /** 查询所有用户记录 */
    private static final String FS_SQL_SELECT_USER = "SELECT * FROM user ";

    public List<WeightRecord> selectAll(WebPager pager) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        int rowNumber = selectTotalNumber();
        int pageNumber = (rowNumber + pager.getPageSize() - 1)/pager.getPageSize();
        if(pager.getCurrentPage() > pageNumber){
            pager.setCurrentPage(pageNumber);
        }
        if(pager.getCurrentPage() < 1){
            pager.setCurrentPage(1);
        }
        StringBuffer sql = new StringBuffer(FS_SQL_SELECT);
        sql.append(FS_SQL_ORDERBY + "date DESC");
        sql.append(" LIMIT " + (pager.getCurrentPage() - 1) * pager.getPageSize() + "," + pager.getPageSize());
        System.out.println(sql);
        pager.setRowNumber(rowNumber);
        pager.setPageNumber(pageNumber);
        List<WeightRecord> list = queryRunner.query(sql.toString(), new BeanListHandler<WeightRecord>(WeightRecord.class));
        return list;
    }

    public WeightRecord selectById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String selectById = "select * from weight_record where id=?";
        WeightRecord query = queryRunner.query(selectById, new BeanHandler<WeightRecord>(WeightRecord.class), id);
        return query;
    }

    public void insert(WeightRecord wr) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String insertSql = "insert into weight_record(id, date, runAgoWeight, runAfterWeight, bathAfterWeight, " +
                "sleepAgoWeight, isRun) values (null,?,?,?,?,?,?)";
        queryRunner.update(insertSql, wr.getDate(), wr.getRunAgoWeight(),
                wr.getRunAfterWeight(), wr.getBathAfterWeight(), wr.getSleepAgoWeight(), wr.getIsRun());
    }

    public void updataById(WeightRecord wr) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String updateByIdSql = "update weight_record set date=?,runAgoWeight=?,runAfterWeight=?,bathAfterWeight=?," +
                "sleepAgoWeight=?,isRun=? where id=?";
        queryRunner.update(updateByIdSql, wr.getDate(), wr.getRunAgoWeight(), wr.getRunAfterWeight(),
                wr.getBathAfterWeight(), wr.getSleepAgoWeight(), wr.getIsRun(), wr.getId());
    }


    public int selectTotalNumber() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        long number = (Long)queryRunner.query("SELECT COUNT(*) FROM weight_record ", new ScalarHandler());
        return (int)number;
    }

    public User selectUserByUsernameAndPassword(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        StringBuffer sb = new StringBuffer(FS_SQL_SELECT_USER);
        sb.append("WHERE username=? AND password=?");
        User resultUser = qr.query(sb.toString(), new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
        return resultUser;
    }
}

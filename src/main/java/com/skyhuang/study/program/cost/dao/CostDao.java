package com.skyhuang.study.program.cost.dao;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.jdbc.DataSourceUtils;
import com.skyhuang.study.program.cost.domain.Cost;
import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/11/22.
 */
public class CostDao {

    /** 查询所有收支记录 */
    private static final String FS_SQL_SELECT = "SELECT * FROM cost ";
    /** order by */
    private static final String FS_SQL_ORDERBY = " ORDER BY ";
    /** 查询所有用户记录 */
    private static final String FS_SQL_SELECT_USER = "SELECT * FROM user ";

    public List<Cost> selectAll(WebPager pager) throws SQLException {
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
        List<Cost> list = queryRunner.query(sql.toString(), new BeanListHandler<Cost>(Cost.class));
        return list;
    }

    public int selectTotalNumber() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        long number = (Long)queryRunner.query("SELECT COUNT(*) FROM cost ", new ScalarHandler());
        return (int)number;
    }

    public int insert(Cost cost) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String insertSql = "insert into cost(id, date, incomeAndOutType, costType, money, remark) values (null,?,?,?,?,?)";
        return queryRunner.update(insertSql, cost.getDate(), cost.getIncomeAndOutType(),cost.getCostType(),cost.getMoney(),cost.getRemark());
    }

    public Cost selectById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String selectById = "select * from cost where id=?";
        Cost query = queryRunner.query(selectById, new BeanHandler<Cost>(Cost.class), id);
        return query;
    }

    public void updateById(Cost wr) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String updateByIdSql = "update cost set date=?,incomeAndOutType=?,costType=?, money=?, remark=? where id=?";
        queryRunner.update(updateByIdSql, wr.getDate(), wr.getIncomeAndOutType(), wr.getCostType(), wr.getMoney(),wr.getRemark(), wr.getId());
    }
}

package com.skyhuang.study.program.upDownload.dao;

import com.skyhuang.study.jdbc.DataSourceUtils;
import com.skyhuang.study.program.upDownload.domain.Resources;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/16.
 */
public class UpDownloadDaoImple implements UpDownloadDao{

    public void insert(Resources res) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String insertSql = "insert into resources(id, uuidname, realname, savepath, uploadtime," +
                " description) values (null,?,?,?,?,?)";
        queryRunner.update(insertSql, res.getUuidname(), res.getRealname(),
                res.getSavepath(), res.getUploadtime(),res.getDescription());

    }

    public List<Resources> selectAll() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String selectAll = "select * from resources";
        List<Resources> query = runner.query(selectAll, new BeanListHandler<Resources>(Resources.class));
        return query;
    }

}

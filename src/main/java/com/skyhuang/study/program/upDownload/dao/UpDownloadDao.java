package com.skyhuang.study.program.upDownload.dao;

import com.skyhuang.study.program.upDownload.domain.Resources;

import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/10/16.
 */
public interface UpDownloadDao {

    public void insert(Resources resources) throws SQLException;

}

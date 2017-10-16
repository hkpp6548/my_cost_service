package com.skyhuang.study.program.upDownload.service;

import com.skyhuang.study.program.upDownload.dao.UpDownloadDao;
import com.skyhuang.study.program.upDownload.dao.UpDownloadDaoImple;
import com.skyhuang.study.program.upDownload.domain.Resources;

import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/10/16.
 */
public class UpDownloadService {
    private UpDownloadDao upDownloadDao = new UpDownloadDaoImple();

    public void insert(Resources resources) throws SQLException {
        upDownloadDao.insert(resources);
    }
}

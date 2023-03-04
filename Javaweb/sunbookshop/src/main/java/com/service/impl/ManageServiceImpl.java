package com.service.impl;

import com.dao.ManageDao;
import com.dao.impl.ManageDaoImpl;
import com.model.Manage;
import com.service.ManageService;

/**
 * @Author: XIYAN
 * @Date: 2023/3/2 17:04
 * @注释:实现逻辑判断的管理员接口
 */
public class ManageServiceImpl implements ManageService {
    private ManageDao manageDao = new ManageDaoImpl();

    @Override
    public Manage login(Manage manage) {
        return manageDao.selectMange(manage);
    }
}

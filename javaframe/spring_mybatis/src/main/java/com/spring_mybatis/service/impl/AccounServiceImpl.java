package com.spring_mybatis.service.impl;

import com.spring_mybatis.dao.AccountDao;
import com.spring_mybatis.model.Account;
import com.spring_mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 15:09
 * @注释:
 */
@Service
public class AccounServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }
}

package com.spring_mybatis.service;

import com.spring_mybatis.model.Account;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 15:08
 * @注释:
 */
public interface AccountService {
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);
}

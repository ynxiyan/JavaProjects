package com.springboot_ssm.service.impl;

import com.springboot_ssm.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @Author: XIYAN
 * @Date: 2023/3/20 16:08
 * @注释:
 */
@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("run");
    }
}

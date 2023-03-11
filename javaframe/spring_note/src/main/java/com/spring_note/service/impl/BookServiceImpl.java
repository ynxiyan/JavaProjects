package com.spring_note.service.impl;

import com.spring_note.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 11:37
 * @注释:
 */
@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("book service save ...");
    }
}

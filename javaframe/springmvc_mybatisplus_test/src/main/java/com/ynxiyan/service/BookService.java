package com.ynxiyan.service;

import com.ynxiyan.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 11:02
 * @注释:
 */
@Transactional
public interface BookService {
    List<Book> getBookAll();
}

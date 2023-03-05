package com.service;

import com.model.Author;
import com.model.Page;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:21
 * @注释:逻辑判断的作者接口
 */
public interface AuthorService {
    /**
     * 逻辑判断作者列表
     *
     * @param pageSize
     * @param currentPage
     * @return
     */
    Page<Author> list(int pageSize, int currentPage);
}

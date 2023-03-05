package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:08
 * @注释:作者实体
 */
@Data
public class Author {
    //作者序号
    private Integer id;
    //作者名称
    private String name;
    //作者简介
    private String author_introduction;
    //查询总数
    private Integer count;

    public Author() {
    }

    public Author(Integer id, String name, String author_introduction, Integer count) {
        this.id = id;
        this.name = name;
        this.author_introduction = author_introduction;
        this.count = count;
    }
}

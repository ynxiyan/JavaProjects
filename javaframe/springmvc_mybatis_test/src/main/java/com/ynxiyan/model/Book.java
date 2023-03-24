package com.ynxiyan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 9:40
 * @注释:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String book_name;
    private String ISBN;
}

package com.ynxiyan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 14:43
 * @注释:
 */
@TableName("books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "book_name")
    private String bookName;
    @TableField(value = "ISBN")
    private String ISBN;
}

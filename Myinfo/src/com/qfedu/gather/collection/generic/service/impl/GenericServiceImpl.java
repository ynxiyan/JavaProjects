package com.qfedu.gather.collection.generic.service.impl;

import com.qfedu.gather.collection.generic.service.GenericService;

/**
 * @Author: XIYAN
 * @Date: 2023/1/14 15:03
 * @注释:泛型实现方法 注意：
 * 1.作成泛型类:GenericServiceImpl<T> implements GenericService
 * 2.确定引用类型:GenericServiceImpl implements GenericService<String>
 */
public class GenericServiceImpl implements GenericService<String> {
    public static void main(String[] args) {
        GenericServiceImpl genericServiceimpl = new GenericServiceImpl();
        genericServiceimpl.show("123");
    }

    @Override
    public String show(String s) {
        System.out.println(s);
        return s;
    }
}

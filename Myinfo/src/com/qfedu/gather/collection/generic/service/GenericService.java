package com.qfedu.gather.collection.generic.service;

/**
 * @Author: XIYAN
 * @Date: 2023/1/14 14:52
 * @注释:泛型接口(接口名<T(占位符)>)
 */
public interface GenericService<T> {
    //注意：不能创建泛型静态常量！！！
    T show(T t);
}

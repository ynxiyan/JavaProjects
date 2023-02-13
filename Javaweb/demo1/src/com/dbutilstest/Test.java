package com.dbutilstest;

import com.model.Dogs;
import com.utils.BaseDao;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 16:48
 * @注释:
 */
public class Test {
    public static void main(String[] args){
      //
        BaseDao baesDao = new BaseDao();
        String sql="select max(id) from dogs";
        int aggregate = (Integer) baesDao.selectAggregate(sql);
        System.out.println(aggregate);
    }
}

package com.dbutilstest;

import com.utils.BasicDao;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 16:48
 * @注释:
 */
public class Test {
    public static void main(String[] args){
      //
        BasicDao baesDao = new BasicDao();
        String sql = "select max(id) from dogs";
        int aggregate = (Integer) baesDao.selectAggregate(sql);
        System.out.println(aggregate);
    }
}

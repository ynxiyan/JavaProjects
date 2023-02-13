package com.wisezone.features.two.test;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 14:04
 * @注释:
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        //规定Date的格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化字符串
        String str = sf.format(date);
        System.out.println(str);
        Date datestr = sf.parse(str);
        System.out.println(datestr);
    }

    @Test
    public void year() throws ParseException {
        String str = "2015-04-06";
        //格式化字符串
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //字符串转日期对象
        Date date = sf.parse(str);
        //创建当前系统时间
        Calendar cr = Calendar.getInstance();
        //设定星期一为每周的第一天
        cr.setFirstDayOfWeek(Calendar.MONDAY);
        //设定指定时间
        cr.setTime(date);
        //判断并输出指定的时间是一年中的第几个星期----WEEK_OF_YEAR 一年中的第几周<需注意每周的第一天设定为星期几>
        System.out.println(str + "是一年中的第" + cr.get(Calendar.WEEK_OF_YEAR) + "个星期");
    }
}

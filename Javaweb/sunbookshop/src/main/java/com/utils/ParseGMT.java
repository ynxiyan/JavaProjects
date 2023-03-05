package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 16:26
 * @注释:格林威治时间（GMT） 字符串转Date（CST）
 */
public class ParseGMT {
    public static Date parseGMT(String strDate) throws ParseException {
        if (strDate != null && strDate.trim().length() > 0) {
            strDate = strDate.substring(4, 24).replace(" ", "/");
            strDate = strDate.replace("Jan", "01");
            strDate = strDate.replace("Feb", "02");
            strDate = strDate.replace("Mar", "03");
            strDate = strDate.replace("Apr", "04");
            strDate = strDate.replace("May", "05");
            strDate = strDate.replace("Jun", "06");
            strDate = strDate.replace("Jul", "07");
            strDate = strDate.replace("Aug", "08");
            strDate = strDate.replace("Sep", "09");
            strDate = strDate.replace("Oct", "10");
            strDate = strDate.replace("Nov", "11");
            strDate = strDate.replace("Dec", "12");
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy/HH:mm:ss");
            Date date = sdf.parse(strDate);
            return date;
        }
        return null;
    }
}

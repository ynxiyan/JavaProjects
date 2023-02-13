package com.wisezone.oop.six;

import com.wisezone.oop.six.service.InkBox;
import com.wisezone.oop.six.service.Paper;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 10:25
 * @注释:打印机
 */
public class Printer implements InkBox, Paper {

    /**
     * 彩色
     *
     * @return
     */
    @Override
    public String color() {
        return "彩色墨盒";
    }

    /**
     * 黑白
     *
     * @return
     */
    @Override
    public String blackAndWrite() {
        return "黑白墨盒";
    }

    /**
     * A4
     *
     * @return
     */
    @Override
    public String a4() {
        return "A4纸张";
    }

    /**
     * B5
     *
     * @return
     */
    @Override
    public String b5() {
        return "B5纸张";
    }
}

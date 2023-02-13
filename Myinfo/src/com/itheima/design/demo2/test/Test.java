package com.itheima.design.demo2.test;

import com.itheima.design.demo2.Quadrilateral;
import com.itheima.design.demo2.Rectangle;
import com.itheima.design.demo2.Square;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 14:56
 * @注释:<里氏代换原则>
 */
public class Test {
    public static void main(String[] args) {
        //创建长方形
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        //调用扩宽
        resize(rectangle);
        //打印
        print(rectangle);
        //创建正方形
        Square square = new Square();
        //只能调用自己
        square.setSide(12);
    }

    /**
     * 扩宽
     *
     * @param rectangle
     */
    public static void resize(Rectangle rectangle) {
        while (rectangle.getLength() >= rectangle.getWidth()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    /**
     * 打印
     *
     * @param quadrilateral
     */
    public static void print(Quadrilateral quadrilateral) {
        System.out.println(quadrilateral.getLength() + "\t" + quadrilateral.getWidth());
    }
}

package com.wisezone.oop.six.test;

import com.wisezone.oop.six.Printer;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 10:28
 * @注释:
 */
public class TestPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer();
        System.out.println("使用" + printer.blackAndWrite() + "在" + printer.a4() + "上打印");
        System.out.println("使用" + printer.color() + "在" + printer.b5() + "上打印");
        System.out.println("使用" + printer.color() + "在" + printer.a4() + "上打印");
        System.out.println("使用" + printer.blackAndWrite() + "在" + printer.b5() + "上打印");
    }
}

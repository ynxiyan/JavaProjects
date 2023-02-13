package com.wisezone.oop.seven;

import org.apache.log4j.Logger;

import java.util.Scanner;


/**
 * @Author: XIYAN
 * @Date: 2023/1/27 14:09
 * @注释:
 */
public class Test1 {
    private static Logger logger = Logger.getLogger(Test1.class);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 可能发生异常的代码放到 try { } 里
        try {
            System.out.print("请输入被除数:");
            //记录debug日志
            logger.debug("请输入被除数:");
            int num1 = in.nextInt();
            logger.debug("num1===>" + num1);
            System.out.print("请输入除数:");
            logger.debug("请输入除数:");
            int num2 = in.nextInt();
            logger.debug("num2===>" + num2);
            //字符串格式化（x/x=x）
            System.out.println(String.format("%d / %d = %d",
                    num1, num2, num1 / num2));
            logger.debug("num1/num2===>" + num1 / num2);
            //输入不匹配异常 （多重 catch 块注意 ： 先子类后父类 ， 先写小的异常 ， 再写大的 ）
        } catch (Exception e) {

            //打印完整信息
            //e.printStackTrace();
            //打印自定义信息
            System.err.println("程序出错了");
            //记录error日志
            logger.error(e);
            //打印简要信息
            //System.err.println(e.getMessage());
            /*
            有 return 时 ， finally 执行顺序先执行 finally 代码块(大括号里的内容 ， 最后再执行 return)
             */
            return;
            //不管程序发没发生异常 ， 都会执行行 finally 里的代码
        } finally {
            //finally唯一不执行的情况 （ 停掉 JVM System.exit(1);)
            //System.exit(1);
            System.out.println("感谢使用本程序！");
        }
    }
}

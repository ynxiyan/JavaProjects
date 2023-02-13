package com.wisezone.oop.seven;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @Author: XIYAN
 * @Date: 2023/1/27 14:09
 * @注释:
 */
public class Log {
    private static Logger logger = Logger.getLogger(Log.class);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("请输入被除数:");
            int num1 = in.nextInt();
            System.out.print("请输入除数:");
            int num2 = in.nextInt();
            System.out.println(String.format("%d / %d = %d",
                    num1, num2, num1 / num2));
            logger.info("正常运行");
        } catch (InputMismatchException e) {
            logger.error(e);
        } catch (ArithmeticException e) {
            logger.warn(e);
        } finally {
            System.out.println("感谢使用本程序！");
        }
    }
}

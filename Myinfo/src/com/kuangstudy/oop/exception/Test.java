package com.kuangstudy.oop.exception;

/**
 * @Author: XIYAN
 * @Date: 2023/1/9 15:30
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.test(1, 1);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }

//        //监控区域
//        try {
//            System.out.println(1 / 0);
//        }
//        //捕获错误
//        catch (Error e) {
//            System.out.println("Error");
//        }
//        //捕获异常
//        catch (Exception e) {
//            System.out.println("Exception");
//        } catch (Throwable e) {
//            System.out.println("Throwable");
//        }
//        //善后工作
//        finally {
//            System.out.println("finally");
//        }
    }

    //假设这个方法中处理不了这个异常（throws在方法上抛出异常）
    //ArithmeticException：算术异常
    public void test(int a, int b) throws MyException {
        int exp = 1;
        if (a / b == exp) {
            //主动抛出异常（throw在方法里使用）
            throw new MyException(exp);
        }
    }
}

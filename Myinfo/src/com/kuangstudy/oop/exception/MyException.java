package com.kuangstudy.oop.exception;

/**
 * @Author: XIYAN
 * @Date: 2023/1/9 16:02
 * @注释:自定义异常
 */
public class MyException extends Exception {
    private int sum;

    public MyException(int sum) {
        this.sum = sum;
    }

    /**
     * 打印异常
     *
     * @return
     */
    @Override
    public String toString() {
        return "MyException{" +
                "sum=" + sum +
                '}';
    }
}

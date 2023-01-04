package com.wisezone.two;

public class DemoTwo {
    public static void main(String[] args) {
        int numOne = 5;
        int numTwo = 2;
        //求余数
        int number = numOne % numTwo;
        //int取整
        int numberTwo = numOne / numTwo;
        System.out.println(numOne + "%" + numTwo + "=" + number);
        System.out.println(numOne + "/" + numTwo + "=" + numberTwo);
        //自增1
        numOne++;
        //自减1
        numTwo--;
        System.out.println("numOne = " + numOne);
        System.out.println("numTwo = " + numTwo);
    }
}

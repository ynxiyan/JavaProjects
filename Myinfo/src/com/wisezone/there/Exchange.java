package com.wisezone.there;

public class Exchange {
    public static void main(String[] args) {
        int leftNum = 19, rightNUm = 89;
        int temp;
        //暂存
        temp = leftNum;
        //互换
        leftNum = rightNUm;
        rightNUm = temp;
        System.out.println("交换后的leftNum为：" + leftNum);
        System.out.println("交换后的rightNUm为：" + rightNUm);
    }
}

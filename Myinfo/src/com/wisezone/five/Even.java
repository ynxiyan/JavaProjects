package com.wisezone.five;

public class Even {
    public static void main(String[] args) {
//        int i = 1,sum = 0;
//        while (i <= 100){
//            if(i % 2 == 0){
//                sum+=i;
////                sum = sum + i;
//            }
//            i++;
//        }
        int i = 2, sum = 0;
        while (i <= 100) {
            sum += i;
            i += 2;
        }
        System.out.println("1-100的偶数之和是:" + sum);
    }
}

package com.wisezone.four.test;

public class TestOne {
    public static void main(String[] args) {
        int rank = 1;
//        if(rank == 1){
//            System.out.println("xxxx夏令营");
//        } else if (rank == 2) {
//            System.out.println("奖励笔记本");
//        } else if (rank == 3) {
//            System.out.println("奖励移动硬盘");
//        }else {
//            System.out.println("没有奖励");
//        }
        /*
        switch小括号里只能用六种类型  byte char short int enum(枚举) String
         */
        switch (rank) {
            case 1:
                System.out.println("xxxx夏令营");
                break;
            case 2:
                System.out.println("奖励笔记本");
                break;
            case 3:
                System.out.println("奖励移动硬盘");
                break;
            default:
                System.out.println("没有奖励");
                break;
        }
    }
}

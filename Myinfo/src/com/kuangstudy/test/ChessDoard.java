package com.kuangstudy.test;

/**
 * @Author: XIYAN
 * @Date: 2023/1/6 14:37
 * @注释:棋盘(稀疏数组)
 */
public class ChessDoard {
    //1. 创建一个二维数组 11*11
    // 0：没有棋子（数组默认值）
    // 1：黑子
    // 2：白子
    static String chessman = "0";

    public static void main(String[] args) {
        int[][] chess = new int[11][11]; //棋盘数据
        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[6][6] = 2;
        chess[9][9] = 1;
        chess[8][5] = 1;
        chess[4][10] = 2;
        System.out.println("棋盘：");
        print(chess);
        //保存棋盘数据成稀疏数组
        int valid = 0; //棋子数
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0) {
                    valid++;
                }
            }
        }
        int[][] sparseArray = new int[valid + 1][3]; //稀疏数组
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = valid;
        int value = 0; //棋子坐标
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0) {
                    value++;
                    sparseArray[value][0] = i;
                    sparseArray[value][1] = j;
                    sparseArray[value][2] = chess[i][j];
                }
            }
        }
        System.out.println("棋盘数据：");
        System.out.println("\t\t行\t列\t值\t棋子");
        for (int i = 0; i < sparseArray.length; i++) {
            if (i == 0) {
                System.out.println("棋盘总览：" + sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2]);
            } else {
                if (sparseArray[i][2] == 1) {
                    chessman = "黑";
                }
                if (sparseArray[i][2] == 2) {
                    chessman = "白";
                }
                System.out.println("\t\t" + (sparseArray[i][0] + 1) + "\t" + (sparseArray[i][1] + 1) + "\t" + chessman);
                chessman = "0";
            }
        }
        //还原
        int[][] restore = new int[sparseArray[0][0]][sparseArray[0][1]];  //还原数据组
        for (int i = 1; i < sparseArray.length; i++) {
            restore[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("棋盘还原：");
        print(restore);
    }

    /**
     * 棋盘输出
     *
     * @param array
     */
    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    chessman = "黑";
                }
                if (array[i][j] == 2) {
                    chessman = "白";
                }
                System.out.print(chessman + "\t");
                chessman = "0";
            }
            System.out.println();
        }
    }
}

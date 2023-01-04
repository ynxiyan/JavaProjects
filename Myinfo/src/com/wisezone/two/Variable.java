package com.wisezone.two;

public class Variable {
    public static void main(String[] args) {
        /*
        使用变量存储以下MP3信息，并打印输出
        品牌（brand）：爱国者F928
        重量（weight）：12.4
        电池类型（type）：内置锂电池
        价格（price）：499
         */
        String brand, type;
        double weight, price;
        brand = "爱国者F928";
        weight = 12.4;
        type = "内置锂电池";
        price = 499;
        System.out.print("品牌:" + brand + "\n重量:" + weight + "\n电池类型:" + type + "\n价格:" + price);
    }
}

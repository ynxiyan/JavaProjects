package com.wisezone.oop.two.test;

import com.wisezone.oop.two.Cell;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 11:28
 * @注释:
 */
public class TestCell {
    public static void main(String[] args) {
        Cell cell = new Cell();
        cell.brand = "南孚";
        cell.electricity = "65";
        cell.showCell();
        String batterylife = cell.batterylife();
        System.out.println(batterylife);
    }
}

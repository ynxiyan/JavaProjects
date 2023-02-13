package com.wisezone.reply.shop.model;

/**
 * @Author: XIYAN
 * @Date: 2023/1/31 8:55
 * @注释:图书类
 */
public class Books {
    //图书名称
    private String bookName;
    //图书价格
    private double bookPrice;
    //图书库存
    private int inventory;

    public Books() {
    }

    public Books(String bookName, double bookPrice, int inventory) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.inventory = inventory;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return bookName + "\t" + bookPrice + "\t" + inventory;
    }
}

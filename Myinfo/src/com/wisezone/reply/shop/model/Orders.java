package com.wisezone.reply.shop.model;

/**
 * @Author: XIYAN
 * @Date: 2023/1/31 8:56
 * @注释:订单类
 */
public class Orders extends Books {
    //收货人
    private String ordName;
    //总价
    private double price;

    public Orders() {
    }

    public Orders(String ordName, String bookName, double bookPrice, int inventory, double price) {
        super(bookName, bookPrice, inventory);
        this.ordName = ordName;
        this.price = price;
    }

    public String getOrdName() {
        return ordName;
    }

    public void setOrdName(String ordName) {
        this.ordName = ordName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        price = price;
    }

    @Override
    public String toString() {
        return ordName + "\t" + getBookName() + "\t" + getBookPrice() + "\t" + getInventory() + "\t" + price;
    }
}

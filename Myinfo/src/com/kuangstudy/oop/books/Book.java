package com.kuangstudy.oop.books;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 16:47
 * @注释:图书
 */
public class Book {
    //属性：书名、作者、出版社、价格
    private String bookName;
    private String author;
    private String publishing;
    private double price;

    public Book(String bookName, String author, String publishing, double price) {
        this.bookName = bookName;
        this.author = author;
        this.publishing = publishing;
        setPrice(price);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //限定图书价格必须大于10，如果无效需进行提示，并强制赋值为10
        if (price < 10) {
            System.out.println("您输入的图书价格不合法，默认为10元");
            this.price = 10;
        } else {
            this.price = price;
        }
    }

    //方法：信息介绍
    //信息介绍方法描述图书所有信息
    @Override
    public String toString() {
        return "书名：" + bookName + "，作者：" + author + "，出版社：" + publishing + "，价格：" + price;
    }
}

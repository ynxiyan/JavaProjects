package com.wisezone.oop.two.test;

import com.wisezone.oop.two.CustomeBiz;
import com.wisezone.oop.two.Customer;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 12:37
 * @注释:
 */
public class TestCusb {
    public static void main(String[] args) {
        Customer customerOne = new Customer();
        Customer customerTwo = new Customer();
        customerOne.name = "王一";
        customerOne.age = 30;
        customerOne.flang = "无会员";
        customerTwo.name = "郝强";
        customerTwo.age = 19;
        customerTwo.flang = "有会员";
        CustomeBiz customeBiz = new CustomeBiz();
        customeBiz.addCustomer(customerOne);
        customeBiz.addCustomer(customerTwo);
        customeBiz.showCustomers();
    }
}

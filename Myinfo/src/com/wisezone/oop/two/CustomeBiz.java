package com.wisezone.oop.two;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 12:25
 * @注释:
 */
public class CustomeBiz {
    Customer[] customers = new Customer[30];

    /**
     * 添加信息
     *
     * @param cust
     */
    public void addCustomer(Customer cust) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                if ("有会员".equals(cust.flang)) {
                    cust.flang = "true";
                } else {
                    cust.flang = "false";
                }
                customers[i] = cust;
                break;
            }
        }
    }

    /**
     * 显示信息
     */
    public void showCustomers() {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                customers[i].show();
            }
        }
    }
}

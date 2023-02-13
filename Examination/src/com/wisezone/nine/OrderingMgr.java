package com.wisezone.nine;

import java.util.Objects;

/**
 * @Author: XIYAN
 * @Date: 2023/1/3 9:58
 * @注释:订单类
 */
public class OrderingMgr {
    private String name;
    private String address;
    private int quantity;
    private int time;
    int serial = 1;
    double price, total;
    String food;
    boolean flag;
    //二维数组顺序：序号，菜品，单价，数量，总金额，订餐人，送餐地址，送餐时间，订单状态
    String[][] order = new String[30][9];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * 餐费及菜品
     */
    public double charges(int serial) {
        //判断菜品序号
        if (serial == 1) {
            food = OrderingBiz.DISHES[0][1];
            price = Double.parseDouble(OrderingBiz.DISHES[0][2]);

        } else if (serial == 2) {
            food = OrderingBiz.DISHES[1][1];
            price = Double.parseDouble(OrderingBiz.DISHES[1][2]);
        } else {
            food = OrderingBiz.DISHES[2][1];
            price = Double.parseDouble(OrderingBiz.DISHES[2][2]);
        }
        //计算餐费
        total = price * getQuantity();
        //存储订单
        outside:
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < Objects.requireNonNull(order[i]).length; j++) {
                if (order[i][j] == null) {
                    order[i][j] = String.valueOf(this.serial);
                    this.serial += 1;
                    order[i][(j + 1)] = food;
                    order[i][(j + 2)] = String.valueOf(price);
                    order[i][(j + 3)] = String.valueOf(getQuantity());
                    order[i][(j + 4)] = String.valueOf(total);
                    order[i][(j + 5)] = getName();
                    order[i][(j + 6)] = getAddress();
                    order[i][(j + 7)] = String.valueOf(getTime());
                    order[i][(j + 8)] = "已预订";
                    break outside;
                }
            }
        }
        return total;
    }

    /**
     * 更新订单
     *
     * @param serialOrder
     */
    public boolean update(String serialOrder) {
        flag = true;
        outside:
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < order[i].length; j++) {
                if (order[i][j] != null) {
                    if (order[i][0].equals(serialOrder)) {
                        if (order[i][(j + 8)].equals("已签收")) {
                            System.out.println("订单已被签收，请重新输入订单序号！");
                            flag = false;
                            break outside;
                        } else {
                            order[i][(j + 8)] = "已签收";
                            System.out.println("订单签收成功！");
                            flag = false;
                            break outside;
                        }
                    }
                } else {
                    System.out.println("未查找到订单序号！");
                    break outside;
                }
            }
        }
        return flag;
    }

    /**
     * 删除订单
     *
     * @param serialOrder
     * @return
     */
    public boolean delete(String serialOrder) {
        flag = true;
        outside:
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < order[i].length; j++) {
                if (order[i][j] != null) {
                    if (order[i][0].equals(serialOrder)) {
                        if (!order[i][(j + 8)].equals("已签收")) {
                            System.out.println("您选择的订单未被签收不能删除，请重新输入订单序号！");
                            break outside;
                        } else {
                            for (int k = i + 1; k < order.length; k++) {
                                String[] temp = order[k];
                                order[i] = order[k];
                                order[k] = temp;
                            }
                            System.out.println("订单删除成功！");
                            flag = false;
                            break outside;
                        }
                    }
                } else {
                    System.out.println("未查找到订单序号！");
                    break outside;
                }
            }
        }
        return flag;
    }
}

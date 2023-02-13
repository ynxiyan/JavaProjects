package com.wisezone.nine;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/3 9:59
 * @注释:
 */
public class OrderingBiz {
    boolean flag = true;
    //菜品（常量）
    static final String[][] DISHES = {{"1", "红烧带鱼", "38.0", "0"}, {"2", "鱼香肉丝", "20.0"}, {"3", "时令鲜蔬", "10.0"}};
    //点赞数
    int[][] support = {{1, 0}, {2, 0}, {3, 0}};
    OrderingMgr orderingMgr = new OrderingMgr();
    Scanner input = new Scanner(System.in);

    /**
     * 菜单
     */
    public void menu() {
        System.out.println("欢迎使用“吃货联盟订餐系统”");
        System.out.println("****************");
        System.out.println("1.我要订餐\n2.查看餐袋\n3.签收订单\n4.删除订单\n5.我要点赞\n6.退出系统");
        System.out.println("****************");
        System.out.print("请选择：");
        int num = input.nextInt();
        switch (num) {
            case 1:
                orderFood();
                break;
            case 2:
                showPocketBook();
                break;
            case 3:
                signOrder();
                break;
            case 4:
                deleteOrder();
                break;
            case 5:
                like();
                break;
            case 6:
                System.out.println("谢谢使用，欢迎下次光临！");
                System.exit(1);
                break;
            default:
                break;
        }
    }

    /**
     * 菜品
     */
    public void dishes() {
        System.out.println("序号\t\t菜品\t\t\t单价\t\t\t点赞数");
        System.out.println(DISHES[0][0] + "\t\t" + DISHES[0][1] + "\t\t" + DISHES[0][2] + "\t\t" + support[0][1] + "\n" + DISHES[1][0] + "\t\t" + DISHES[1][1] + "\t\t" + DISHES[1][2] + "\t\t" + support[1][1] + "\n" + DISHES[2][0] + "\t\t" + DISHES[2][1] + "\t\t" + DISHES[2][2] + "\t\t" + support[2][1]);
    }

    public void orderList() {
        System.out.println("序号\t\t订餐人\t\t餐品信息\t\t送餐时间\t\t总金额\t\t订单状态");
        for (int i = 0; i < orderingMgr.order.length; i++) {
            for (int j = 0; j < orderingMgr.order[i].length; j++) {
                if (orderingMgr.order[i][j] != null) {
                    System.out.println(orderingMgr.order[i][0] + "\t\t" + orderingMgr.order[i][5] + "\t\t\t" + orderingMgr.order[i][1] + "" + orderingMgr.order[i][3] + "份\t" + orderingMgr.order[i][7] + "点\t\t" + orderingMgr.order[i][4] + "\t\t" + orderingMgr.order[i][8]);
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("订单列表为空！");
        }
    }

    /**
     * 返回
     */
    public void back() {
        for (; ; ) {
            System.out.print("输入0返回：");
            int num = input.nextInt();
            if (num == 0) {
                menu();
            } else {
                System.out.println("非法输入，请重新输入！");
            }
        }
    }

    /**
     * 1.我要订餐
     */
    public void orderFood() {
        System.out.println("***我要订餐***");
        System.out.print("请输入订餐人姓名：");
        String name = input.next();
        orderingMgr.setName(name);
        dishes();
        System.out.print("\n请选择您要点的菜品序号：");
        int serial = input.nextInt();
        System.out.print("请选择您需要的份数：");
        int quantity = input.nextInt();
        orderingMgr.setQuantity(quantity);
        for (; ; ) {
            System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）：");
            int time = input.nextInt();
            if (time < 10 || time > 20) {
                System.out.println("不在送餐范围，请重新输入！");
            } else {
                orderingMgr.setTime(time);
                break;
            }
        }
        System.out.print("请输入送餐地址：");
        String address = input.next();
        orderingMgr.setAddress(address);
        orderingMgr.charges(serial);
        System.out.println("订餐成功！");
        System.out.println("您订的是：" + orderingMgr.food + "" + orderingMgr.getQuantity() + "份");
        System.out.println("送餐时间：" + orderingMgr.getTime() + "点");
        System.out.println("餐费：" + orderingMgr.total + "元，送餐费0.0元。\t总计：" + orderingMgr.total + "元。");
        back();
    }

    /**
     * 2.查看餐袋
     */
    public void showPocketBook() {
        System.out.println("***查看钱袋***");
        orderList();
        back();
    }

    /**
     * 3.签收订单
     */
    public void signOrder() {
        System.out.println("***签收订单***");
        orderList();
        if (flag) {
        } else {
            do {
                System.out.print("请选择要签收的订单序号：");
                String serialOrder = input.next();
                orderingMgr.update(serialOrder);
            } while (orderingMgr.flag);
            orderList();
        }
        back();
    }

    /**
     * 4.删除订单
     */
    public void deleteOrder() {
        System.out.println("***删除订单***");
        orderList();
        if (flag) {
        } else {
            do {
                System.out.print("请输入要删除的订单序号：");
                String serialOrder = input.next();
                orderingMgr.delete(serialOrder);
            } while (orderingMgr.flag);
            orderList();
        }
        back();
    }

    /**
     * 5.我要点赞
     */
    public void like() {
        System.out.println("***我要点赞***");
        dishes();
        do {
            System.out.print("请选择您要点赞的菜品序号：");
            int serialOrder = input.nextInt();
            flag = true;
            outside:
            for (int i = 0; i < support.length; i++) {
                for (int j = 0; j < support[i].length; j++) {
                    if (support[i][0] == serialOrder) {
                        support[i][1] += 1;
                        System.out.println("点赞成功！");
                        flag = false;
                        break outside;
                    }
                }
            }
            if (flag) {
                System.out.println("未查找到菜品序号！");
            }
        } while (flag);
        dishes();
        back();
    }
}

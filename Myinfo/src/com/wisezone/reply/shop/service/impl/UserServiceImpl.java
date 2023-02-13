package com.wisezone.reply.shop.service.impl;

import com.wisezone.reply.shop.exception.SerialException;
import com.wisezone.reply.shop.model.Books;
import com.wisezone.reply.shop.model.Orders;

import static com.wisezone.reply.shop.service.impl.ShopServiceImpl.*;

/**
 * @Author: XIYAN
 * @Date: 2023/1/31 9:28
 * @注释:用户实现类
 */
public class UserServiceImpl {
    static ShopServiceImpl shopServiceImpl = new ShopServiceImpl();
    //登录标注
    static String conversation = ShopServiceImpl.getConversation();
    static int ordNum = 4;

    /**
     * 购买图书
     */
    public static void payShop() throws SerialException, InterruptedException {
        int bookserial, num;
        boolean flag = true;
        while (flag) {
            System.out.print("请输入图书序号：");
            ex();
            bookserial = ShopServiceImpl.input.nextInt();
            System.out.print("请输入购买数量：");
            ex();
            num = ShopServiceImpl.input.nextInt();
            int finalBookSerial = bookserial;
            int finalNum = num;
            //遍历bookMap
            booksMap.forEach((serial, list) -> {
                //查找图书序号是否存在并判断购买数量是否超过库存数量
                if (serial == finalBookSerial & finalNum > list.getInventory()) {
                    System.out.println("\n购买数量不能超过库存数量！");
                    try {
                        payShop();
                        String mapName = list.getBookName();
                        double mapPrice = list.getBookPrice();
                        int temp = list.getInventory() - finalNum;
                        Books newList = new Books(mapName, mapPrice, temp);
                        booksMap.put(serial, newList);
                        carOrder(list);
                    } catch (Exception e) {
                        System.err.println("菜单项不存在！");
                    }
                }
            });
            flag = false;
        }
        System.out.println("\n图书序号不存在！");
        shopServiceImpl.showShop();
    }

    /**
     * 创建订单
     */
    public static void carOrder(Books list) throws SerialException, InterruptedException {
        Orders orders = new Orders(conversation, list.getBookName(), list.getBookPrice(), list.getInventory(), list.getBookPrice() * list.getInventory());
        ordersMap.put((ordNum++), orders);
        System.out.println("购买图书成功");
        shopServiceImpl.showShop();
    }


    /**
     * 查看订单
     */
    public static void showOrder() throws SerialException, InterruptedException {
        System.out.println("图书名称\t\t\t\t图书价格\t\t购买数量\t\t总价");
        //遍历ordersMap
        ordersMap.forEach((serial, list) -> {
            //仅查看当前登录用户的订单信息
            if (list.getOrdName().equals(conversation)) {
                System.out.println(serial + ":" + list.getBookName() + "\t\t" + list.getBookPrice() + "\t\t" + list.getInventory() + "\t\t\t" + list.getPrice());
            }
        });
        System.out.println(" * * * * * * * * * * * * * * * * *");
        System.out.print("输入任意数字返回：");
        ex();
        int serial = input.nextInt();
        switch (serial) {
            default:
                shopServiceImpl.userMenu();
                break;
        }
    }

    /**
     * 删除订单
     */
    public static void delOrder() throws SerialException, InterruptedException {
        System.out.println("图书名称\t\t\t\t图书价格\t\t购买数量\t\t总价");
        //遍历ordersMap
        ordersMap.forEach((serial, list) -> {
            //仅查看当前登录用户的订单信息
            if (list.getOrdName().equals(conversation)) {
                System.out.println(serial + ":" + list.getBookName() + "\t\t" + list.getBookPrice() + "\t\t" + list.getInventory() + "\t\t\t" + list.getPrice());
            }
        });
        int bookserial;
        boolean flag = true;
        while (flag) {
            System.out.print("请输入图书序号：");
            ex();
            bookserial = input.nextInt();
            int finalBookSerial = bookserial;
            //遍历ordersMap
            ordersMap.forEach((serial, list) -> {
                //仅查看当前登录用户的订单信息并查找订单序号是否存在
                if (list.getOrdName().equals(conversation) & serial == finalBookSerial) {
                    ordersMap.remove(serial);
                    System.out.println("删除订单成功");
                    //是否继续访问
                    System.out.println("1.继续删除订单信息\n2.返回");
                    System.out.println(" * * * * * * * * * * * * * * * * *");
                    System.out.print("请选择菜单：");
                    try {
                        ex();
                        int ren = input.nextInt();
                        switch (ren) {
                            case 1:
                                delOrder();
                                break;
                            case 2:
                            default:
                                shopServiceImpl.userMenu();
                                break;
                        }
                    } catch (Exception e) {
                        System.err.println("菜单项不存在！");
                    }
                }
            });
            flag = false;
        }
        System.out.println("\n订单序号不存在！");
        //是否继续访问
        System.out.println("1.继续删除订单信息\n2.返回");
        System.out.println(" * * * * * * * * * * * * * * * * *");
        System.out.print("请选择菜单：");
        ex();
        int ren = input.nextInt();
        switch (ren) {
            case 1:
                delOrder();
                break;
            case 2:
            default:
                shopServiceImpl.userMenu();
                break;
        }
    }
}

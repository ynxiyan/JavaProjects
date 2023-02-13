package com.wisezone.reply.shop.service.impl;

import com.wisezone.reply.shop.exception.SerialException;
import com.wisezone.reply.shop.model.Books;

import static com.wisezone.reply.shop.service.impl.ShopServiceImpl.*;

/**
 * @Author: XIYAN
 * @Date: 2023/1/31 9:28
 * @注释:管理员实现类
 */
public class AdminsServiceImpl {
    static ShopServiceImpl shopServiceImpl = new ShopServiceImpl();
    //登录标注
    static String conversation = ShopServiceImpl.getConversation();
    static int booNum = 5;

    /**
     * 添加图书信息
     */
    public static void addBooks() throws SerialException, InterruptedException {
        String bookName;
        double bookPrice;
        int bookInventory;
        boolean flag = true;
        while (flag) {
            System.out.print("请输入图书名称：");
            bookName = input.next();
            System.out.print("请输入图书价格：");
            ex();
            bookPrice = input.nextDouble();
            System.out.print("请输入图书库存：");
            ex();
            bookInventory = input.nextInt();
            String finalBookName = bookName;
            double finalBookPrice = bookPrice;
            int finalBookInventory = bookInventory;
            Books newList = new Books(finalBookName, finalBookPrice, finalBookInventory);
            booksMap.put((booNum++), newList);
            System.out.println("图书信息添加成功");
            try {
                shopServiceImpl.adminMenu();
            } catch (Exception e) {
                System.err.println("菜单项不存在！");
            }
            flag = false;
        }
        System.out.println("\n图书信息添加失败！");
        addBooks();
    }

    /**
     * 删除图书信息
     */
    public static void delBooks() throws SerialException, InterruptedException {
        System.out.println("图书名称\t\t\t\t图书价格\t\t图书库存");
        //遍历bookMap
        booksMap.forEach((serial, list) -> {
            System.out.println(serial + ":" + list.getBookName() + "\t\t" + list.getBookPrice() + "\t\t" + list.getInventory());
        });
        int bookSerial;
        boolean flag = true;
        while (flag) {
            System.out.print("请输入图书序号：");
            ex();
            bookSerial = input.nextInt();
            int finalBookSerial = bookSerial;
            //遍历bookMap
            booksMap.forEach((serial, list) -> {
                //查找图书序号是否存在
                if (serial == finalBookSerial) {
                    booksMap.remove(serial);
                    System.out.println("删除图书信息成功");
                    //是否继续访问
                    System.out.println("1.继续删除图书信息\n2.返回");
                    System.out.println(" * * * * * * * * * * * * * * * * *");
                    System.out.print("请选择菜单：");
                    try {
                        ex();
                        int ren = input.nextInt();
                        switch (ren) {
                            case 1:
                                delBooks();
                                break;
                            case 2:
                            default:
                                shopServiceImpl.adminMenu();
                                break;
                        }
                    } catch (Exception e) {
                        System.err.println("菜单项不存在！");
                    }
                }
            });
            flag = false;
        }
        System.out.println("\n图书序号不存在！");
        delBooks();
    }

    /**
     * 查看图书信息
     */
    public static void showBooks() throws SerialException, InterruptedException {
        System.out.println("图书名称\t\t\t\t图书价格\t\t图书库存");
        //遍历bookMap
        booksMap.forEach((serial, list) -> {
            System.out.println(serial + ":" + list.getBookName() + "\t\t" + list.getBookPrice() + "\t\t" + list.getInventory());
        });
        System.out.println(" * * * * * * * * * * * * * * * * *");
        System.out.print("输入任意数字返回：");
        ex();
        int serial = input.nextInt();
        switch (serial) {
            default:
                shopServiceImpl.adminMenu();
                break;
        }
    }

    /**
     * 修改图书信息
     */
    public static void upBooks() throws SerialException, InterruptedException {
        System.out.println("图书名称\t\t\t\t图书价格\t\t图书库存");
        //遍历bookMap
        booksMap.forEach((serial, list) -> {
            System.out.println(serial + ":" + list.getBookName() + "\t\t" + list.getBookPrice() + "\t\t" + list.getInventory());
        });
        final String[] bookName = {null};
        final double[] bookPrice = {0};
        int bookSerial;
        final int[] inventory = {0};
        boolean flag = true;
        while (flag) {
            System.out.print("请输入图书序号：");
            ex();
            bookSerial = input.nextInt();
            int finalBookSerial = bookSerial;
            //遍历bookMap
            booksMap.forEach((serial, list) -> {
                //查找图书序号是否存在
                if (serial == finalBookSerial) {
                    System.out.println("修改项：");
                    System.out.println("1.修改图书名称\n2.修改图书价格\n3.修改图书库存\n4.返回");
                    System.out.println(" * * * * * * * * * * * * * * * * *");
                    System.out.print("请选择修改项：");
                    try {
                        ex();
                        int ser = input.nextInt();
                        switch (ser) {
                            case 1:
                                System.out.print("请输入图书名称：");
                                bookName[0] = input.next();
                                break;
                            case 2:
                                System.out.print("请输入图书价格：");
                                ex();
                                bookPrice[0] = input.nextDouble();
                                break;
                            case 3:
                                System.out.print("请输入图书库存：");
                                ex();
                                inventory[0] = input.nextInt();
                                break;
                            case 4:
                                shopServiceImpl.adminMenu();
                                break;
                            default:
                                upBooks();
                                break;
                        }
                    } catch (Exception e) {
                        System.err.println("菜单项不存在！");
                    }
                    //判断当前的修改项
                    if (bookName[0] == null) {
                        bookName[0] = list.getBookName();
                    }
                    if (bookPrice[0] == 0) {
                        bookPrice[0] = list.getBookPrice();
                    }
                    if (inventory[0] == 0) {
                        inventory[0] = list.getInventory();
                    }
                    Books newList = new Books(bookName[0], bookPrice[0], inventory[0]);
                    booksMap.put(serial, newList);
                    System.out.println("修改图书信息成功");
                    //是否继续访问
                    System.out.println("1.继续修改图书信息\n2.返回");
                    System.out.println(" * * * * * * * * * * * * * * * * *");
                    System.out.print("请选择菜单：");
                    try {
                        ex();
                        int ren = input.nextInt();
                        switch (ren) {
                            case 1:
                                upBooks();
                                break;
                            case 2:
                            default:
                                shopServiceImpl.adminMenu();
                                break;
                        }
                    } catch (Exception e) {
                        System.err.println("菜单项不存在！");
                    }
                }
            });
            flag = false;
        }
        System.out.println("\n图书序号不存在！");
        upBooks();
    }
}

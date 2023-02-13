package com.wisezone.reply.shop.service.impl;

import com.wisezone.reply.shop.exception.SerialException;
import com.wisezone.reply.shop.model.Books;
import com.wisezone.reply.shop.model.Orders;
import com.wisezone.reply.shop.model.User;
import com.wisezone.reply.shop.service.ShopService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 18:29
 * @注释:商店实现类
 */
public class ShopServiceImpl implements ShopService {
    public static Scanner input = new Scanner(System.in);
    static Map<Integer, User> userMap = new HashMap<>();
    static Map<Integer, Books> booksMap = new HashMap<>();
    static Map<Integer, Orders> ordersMap = new HashMap<>();
    int useNum = 1, booNum = 1, ordNum = 1, token = 0;
    //登录标注
    static String conversation;

    public static String getConversation() {
        return conversation;
    }

    public void setConversation(String conversation) {
        ShopServiceImpl.conversation = conversation;
    }

    /**
     * 处理异常
     *
     * @throws InterruptedException
     * @throws SerialException
     */
    public static void ex() throws SerialException, InterruptedException {
        if (!input.hasNextInt()) {
            //释放hanNextInt空间中的值
            String dbug = input.next();
            throw new SerialException();
        }
        if (!input.hasNextDouble()) {
            //释放hasNextDouble空间中的值
            String dbug = input.next();
            throw new SerialException();
        }
    }

    /**
     * 菜单
     */
    public void menu() throws SerialException, InterruptedException {
        //初始化数据
        token = 0;
        if (userMap.size() == 0) {
            userMap.put((useNum++), new User("test1", "shopPwd"));
            userMap.put((useNum++), new User("test2", "shopPwd"));
            userMap.put((useNum++), new User("test3", "shopPwd"));
            userMap.put((useNum++), new User("test4", "shopPwd"));
        }
        if (ordersMap.size() == 0) {
            ordersMap.put((ordNum++), new Orders("test1", "Java入门到精通", 49, 1, 49));
            ordersMap.put((ordNum++), new Orders("test2", "Java入门到精通", 49, 2, 98));
            ordersMap.put((ordNum++), new Orders("test3", "HTML入门到精通", 39.1, 4, 156.4));
            ordersMap.put((ordNum++), new Orders("test2", "MySQl入门到精通", 29.5, 1, 29.5));
        }
        if (booksMap.size() == 0) {
            booksMap.put((booNum++), new Books("Java入门到精通", 49, 12));
            booksMap.put((booNum++), new Books("PHP 入门到精通", 66.8, 34));
            booksMap.put((booNum++), new Books("MySQl入门到精通", 29.5, 56));
            booksMap.put((booNum++), new Books(".NET入门到精通", 39.1, 21));
            booksMap.put((booNum++), new Books("HTML入门到精通", 89.9, 18));
        }
        System.out.println("* * * * 欢迎进入基于控制台的图书商店 * * * *");
        System.out.print("1.注册\t\t2.登录\t\n3.查看商店\t4.我的订单\n5.管理员登录\t6.退出系统\n");
        System.out.println("* * * * * * * * * * * * * * * * * * *");
        System.out.print("请选择菜单：");
        ex();
        int serial = input.nextInt();
        loginOut(serial);
        switch (serial) {
            case 1:
                System.out.println("\n- - - -> 当前处于注册界面：");
                System.out.println("1.注册\n2.返回");
                System.out.println(" * * * * * * * * * * * * * * * * *");
                System.out.print("请选择菜单：");
                ex();
                serial = input.nextInt();
                switch (serial) {
                    case 1:
                        enroll();
                        break;
                    case 2:
                    default:
                        menu();
                        break;
                }
                break;
            case 2:
                System.out.println("\n- - - -> 当前处于登录界面：");
                System.out.println("1.登录\n2.返回");
                System.out.println("* * * * * * * * * * * * * * * *");
                System.out.print("请选择菜单：");
                ex();
                serial = input.nextInt();
                switch (serial) {
                    case 1:
                        login();
                        userMenu();
                        break;
                    case 2:
                    default:
                        menu();
                        break;
                }
                break;
            case 3:
                System.out.println("\n- - - -> 当前处于商店界面：");
                showShop();
                break;
            case 4:
                if (conversation == null || "logOut".equals(conversation)) {
                    System.out.println("\n对不起您未登录，请先登录！");
                    login();
                }
                userMenu();
                break;
            case 5:
                System.out.println("\n- - - -> 当前处于管理员登录界面：");
                System.out.println("1.登录\n2.返回");
                System.out.println("* * * * * * * * * * * * * * * *");
                System.out.print("请选择菜单：");
                ex();
                serial = input.nextInt();
                switch (serial) {
                    case 1:
                        adminLogin();
                        adminMenu();
                        break;
                    case 2:
                    default:
                        menu();
                        break;
                }
                break;
            case 6:
                System.exit(1);
                break;
            default:
                menu();
                break;
        }
    }

    /**
     * 管理员菜单
     */
    public void adminMenu() throws SerialException, InterruptedException {
        System.out.println("\n- - - -> 当前处于管理员界面：\t\t\t\t欢迎您：" + conversation);
        System.out.println("1.添加图书信息\n2.删除图书信息\n3.查看图书信息\n4.修改图书信息\n5.返回");
        System.out.println("* * * * * * * * * * * * * * * *");
        System.out.print("请选择菜单：");
        ex();
        int serial = input.nextInt();
        switch (serial) {
            case 1:
                System.out.println("\n- - - -> 当前处于添加图书信息界面");
                AdminsServiceImpl.addBooks();
                break;
            case 2:
                System.out.println("\n- - - -> 当前处于删除图书信息界面");
                AdminsServiceImpl.delBooks();
                break;
            case 3:
                System.out.println("\n- - - -> 当前处于查看图书信息界面");
                AdminsServiceImpl.showBooks();
                break;
            case 4:
                System.out.println("\n- - - -> 当前处于修改图书信息界面");
                AdminsServiceImpl.upBooks();
                break;
            case 5:
                menu();
                break;
            default:
                adminMenu();
                break;
        }
    }

    /**
     * 用户菜单
     */
    public void userMenu() throws SerialException, InterruptedException {
        System.out.println("\n- - - -> 当前处于订单界面；\t\t\t\t欢迎您：" + conversation);
        System.out.println("1.查看订单\n2.删除订单\n3.返回");
        System.out.println("* * * * * * * * * * * * * * * *");
        System.out.print("请选择菜单：");
        ex();
        int serial = input.nextInt();
        switch (serial) {
            case 1:
                System.out.println("\n- - - -> 当前处于查看订单界面：");
                UserServiceImpl.showOrder();
                break;
            case 2:
                System.out.println("\n- - - -> 当前处于删除订单界面：");
                UserServiceImpl.delOrder();
                break;
            case 3:
                menu();
                break;
            default:
                userMenu();
                break;
        }
    }

    /**
     * 登录
     */
    @Override
    public void login() {
        String name = null, pwd = null;
        boolean flag = true;
        while (flag) {
            System.out.print("请输入用户名：");
            name = input.next();
            System.out.print("请输入密码：");
            pwd = input.next();
            if (name.length() < 3 || pwd.length() < 6) {
                System.out.println("\n用户名长度不能小于3，密码长度不能小于6！");
                continue;
            }
            flag = false;
        }
        String finalName = name;
        String finalPwd = pwd;
        userMap.forEach((serial, list) -> {
            if (list.getName().equals(finalName) & list.getPwd().equals(finalPwd)) {
                conversation = finalName;
                try {
                    if (token == 1) {
                        showShop();
                    } else {
                        userMenu();
                    }
                } catch (Exception e) {
                    System.err.println("菜单项不存在！");
                }

            }
        });
        System.out.println("\n用户名或密码不正确！");
        login();
    }

    /**
     * 退出登录
     */
    @Override
    public void loginOut(int serial) throws SerialException, InterruptedException {
        if (serial == 1 || serial == 2 || serial == 4 || serial == 5) {
            if (serial == 4) {
                if (!"admin".equals(conversation) & !"logOut".equals(conversation) & conversation != null) {
                    userMenu();
                }
            }
            if (serial == 5) {
                if ("admin".equals(conversation)) {
                    adminMenu();
                }
            }
            if (conversation != null & !"logOut".equals(conversation)) {
                System.out.println("\n当前系统已有用户登录<" + conversation + ">，请先退出登录！");
                System.out.println("1.退出登录\n2.返回");
                System.out.println("* * * * * * * * * * * * * * * *");
                System.out.print("请选择菜单：");
                ex();
                serial = input.nextInt();
                switch (serial) {
                    case 1:
                        conversation = "logOut";
                        menu();
                        break;
                    case 2:
                        menu();
                        break;
                    default:
                        loginOut(serial);
                        break;
                }
            }
        }
    }

    /**
     * 注册
     */
    @Override
    public void enroll() throws SerialException, InterruptedException {
        String name = null, pwd = null, pwds = null;
        boolean flag = true;
        while (flag) {
            System.out.print("请输入用户名：");
            name = input.next();
            System.out.print("请输入密码：");
            pwd = input.next();
            if (name.length() < 3 || pwd.length() < 6) {
                System.out.println("\n用户名长度不能小于3，密码长度不能小于6！");
                continue;
            }
            flag = false;
        }
        flag = true;
        while (flag) {
            System.out.print("请再次输入密码：");
            pwds = input.next();
            if (!pwds.equals(pwd)) {
                System.out.println("\n两次输入的密码不相同！");
                continue;
            }
            flag = false;
        }
        String finalName = name;
        userMap.forEach((serial, list) -> {
            if (list.getName().equals(finalName)) {
                System.out.println("\n用户名已存在！");
                //是否继续访问
                System.out.println("1.继续注册\n2.返回");
                System.out.println(" * * * * * * * * * * * * * * * * *");
                System.out.print("请选择菜单：");
                try {
                    ex();
                    int ren = ShopServiceImpl.input.nextInt();
                    switch (ren) {
                        case 1:
                            enroll();
                            break;
                        case 2:
                        default:
                            menu();
                            break;
                    }
                } catch (Exception e) {
                    System.err.println("菜单项不存在！");
                }
            }
        });
        User user = new User(name, pwd);
        userMap.put((useNum++), user);
        System.out.println("注册成功！请牢记用户名和密码。");
        menu();
    }

    /**
     * 查看商店
     */
    @Override
    public void showShop() throws SerialException, InterruptedException {
        System.out.println("图书名称\t\t\t\t图书价格\t\t图书库存");
        //遍历bookMap
        booksMap.forEach((serial, list) -> {
            //删除图书库存为0的图书信息
            if (list.getInventory() == 0) {
                booksMap.remove(serial);
            } else {
                System.out.println(serial + ":" + list.getBookName() + "\t\t" + list.getBookPrice() + "\t\t" + list.getInventory());
            }
        });
        System.out.println("1.购买\n2.返回");
        System.out.println(" * * * * * * * * * * * * * * * * *");
        System.out.print("请选择菜单：");
        ex();
        int serial = input.nextInt();
        switch (serial) {
            case 1:
                if (conversation == null || "logOut".equals(conversation) || "admin".equals(conversation)) {
                    System.out.println("\n对不起您未登录或当前用户权限无效，请先登录！");
                    token = 1;
                    login();
                }
                UserServiceImpl.payShop();
                break;
            case 2:
                menu();
                break;
            default:
                showShop();
                break;
        }
    }

    /**
     * 管理员登录
     */
    @Override
    public void adminLogin() throws SerialException, InterruptedException {
        String name = null, pwd = null;
        String adminName = "admin", adminPwd = "adminPwd";
        boolean flag = true;
        while (flag) {
            System.out.print("请输入用户名：");
            name = input.next();
            System.out.print("请输入密码：");
            pwd = input.next();
            if (name.length() < 3 || pwd.length() < 6) {
                System.out.println("\n用户名长度不能小于3，密码长度不能小于6！");
                continue;
            }
            flag = false;
        }
        if (adminName.equals(name) & adminPwd.equals(pwd)) {
            conversation = name;
            adminMenu();
        }
        System.out.println("\n用户名或密码不正确！");
        adminLogin();
    }
}

package com.wisezone.reply.shop.service;

import com.wisezone.reply.shop.exception.SerialException;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 18:27
 * @注释:商店接口
 */
public interface ShopService {
    /**
     * 登录
     */
    void login();

    /**
     * 退出登录
     */
    void loginOut(int serial) throws SerialException, InterruptedException;

    /**
     * 注册
     */
    void enroll() throws SerialException, InterruptedException;

    /**
     * 查看商店
     */
    void showShop() throws SerialException, InterruptedException;

    /**
     * 管理员登录
     */
    void adminLogin() throws SerialException, InterruptedException;
}

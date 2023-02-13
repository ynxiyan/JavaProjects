package com.wisezone.reply.shop.test;

import com.wisezone.reply.shop.exception.SerialException;
import com.wisezone.reply.shop.service.impl.ShopServiceImpl;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 18:28
 * @注释:
 */
public class TestShop {
    public static void main(String[] args) throws SerialException, InterruptedException {
        new ShopServiceImpl().menu();
    }
}

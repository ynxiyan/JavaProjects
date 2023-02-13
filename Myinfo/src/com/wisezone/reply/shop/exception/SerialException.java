package com.wisezone.reply.shop.exception;

import com.wisezone.reply.shop.service.impl.ShopServiceImpl;

/**
 * @Author: XIYAN
 * @Date: 2023/1/31 16:07
 * @注释:自定义序号异常
 */
public class SerialException extends Exception {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public SerialException() throws InterruptedException, SerialException {
        System.out.println("由于发生异常，系统将在3秒后回溯至主菜单...");
        System.err.println("\t\t\t请合法操作");
        Thread.sleep(100);
        System.out.println(" * * * * * * * * * * * * * * * * *\n");
        //睡眠3秒
        Thread.sleep(3000);
        ShopServiceImpl shopServiceImpl = new ShopServiceImpl();
        shopServiceImpl.menu();
    }
}

package com.wisezone.oop.six;

import com.wisezone.oop.six.service.Lock;
import com.wisezone.oop.six.service.Photo;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 9:46
 * @注释:
 */
public class TheftproofDoor extends Door implements Lock, Photo {
    @Override
    public void open() {
        System.out.println("门开了");
    }

    @Override
    public void close() {
        System.out.println("门关了");
    }

    @Override
    public void lockUp() {
        System.out.println("已上锁");
    }

    @Override
    public void openLock() {
        System.out.println("已开锁");
    }

    @Override
    public void photo() {
        System.out.println("已拍照");
    }
}

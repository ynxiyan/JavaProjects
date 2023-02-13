package com.wisezone.oop.six.service.impl;

import com.wisezone.oop.six.Handset;
import com.wisezone.oop.six.service.PlayWiring;
import com.wisezone.oop.six.service.TheakePictures;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 11:05
 * @注释:普通手机
 */
public class CommonHandset extends Handset implements TheakePictures, PlayWiring {
    /**
     * 播放
     *
     * @param content
     */
    @Override
    public void play(String content) {
        System.out.println("播放" + content);
    }

    /**
     * 拍照
     */
    @Override
    public void takePictures() {
        System.out.println("照相");
    }
}

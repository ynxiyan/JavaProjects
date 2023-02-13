package com.wisezone.oop.six.service.impl;

import com.wisezone.oop.six.Handset;
import com.wisezone.oop.six.service.Network;
import com.wisezone.oop.six.service.PlayWiring;
import com.wisezone.oop.six.service.TheakePictures;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 11:05
 * @注释:智能手机
 */
public class AptitudeHandset extends Handset implements TheakePictures, PlayWiring, Network {
    /**
     * 连接网络
     */
    @Override
    public void networkConn() {
        System.out.println("上网");
    }

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

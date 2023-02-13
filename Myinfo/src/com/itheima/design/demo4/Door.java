package com.itheima.design.demo4;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 9:22
 * @注释:
 */
public class Door implements AntiTher, Fireproof, Waterproof {
    /**
     * 防盗
     */
    @Override
    public void antiTher() {
        System.out.println("防盗功能");
    }

    /**
     * 防火
     */
    @Override
    public void fireProof() {
        System.out.println("防火功能");
    }

    /**
     * 防水
     */
    @Override
    public void waterProof() {
        System.out.println("防水功能");
    }
}

package com.itheima.design.demo1.test;

import com.itheima.design.demo1.CustSkin;
import com.itheima.design.demo1.DefaultSkin;
import com.itheima.design.demo1.SouGouInput;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 14:22
 * @注释:用户界面 <开闭原则>
 * 对拓展开放，对修改关闭
 */
public class TestSkin {
    public static void main(String[] args) {
        //使用皮肤
        SouGouInput souGouInput = new SouGouInput();
        //用户选择皮肤
        DefaultSkin defaultSkin = new DefaultSkin();
        CustSkin custSkin = new CustSkin();
        //调用
        souGouInput.setSkin(defaultSkin);
        //显示
        souGouInput.display();
    }
}

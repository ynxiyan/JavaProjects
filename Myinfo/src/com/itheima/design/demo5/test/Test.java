package com.itheima.design.demo5.test;

import com.itheima.design.demo5.Agent;
import com.itheima.design.demo5.Company;
import com.itheima.design.demo5.Fans;
import com.itheima.design.demo5.Star;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 10:10
 * @注释:<迪米特法则>
 */
public class Test {
    public static void main(String[] args) {
        //创建经纪人
        Agent agent = new Agent();
        //创建明星
        Star star = new Star("张三");
        agent.setStar(star);
        //创建粉丝
        Fans fans = new Fans("李四");
        agent.setFans(fans);
        //创建公司
        Company company = new Company("XX公司");
        agent.setCompany(company);
        //和粉丝见面
        agent.meetIng();
        //和公司洽谈业务
        agent.business();
    }
}

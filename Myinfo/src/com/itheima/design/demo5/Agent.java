package com.itheima.design.demo5;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 9:49
 * @注释:经纪人
 */
public class Agent {
    //聚合
    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * 和粉丝见面
     */
    public void meetIng() {
        System.out.println(star.getName() + "和粉丝" + fans.getName() + "见面");
    }

    /**
     * 和公司洽谈业务
     */
    public void business() {
        System.out.println(star.getName() + "和" + company.getName() + "洽谈业务");
    }
}

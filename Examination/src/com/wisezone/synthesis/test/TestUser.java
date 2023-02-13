package com.wisezone.synthesis.test;

import com.wisezone.synthesis.User;
import com.wisezone.synthesis.exception.AgeException;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 9:03
 * @注释:要求年龄不能小于0或大于130岁，并抛出年龄不正确异常。
 */
public class TestUser {
    User user=new User();
    public static void main(String[] args) throws AgeException {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入年龄：");
        int age =input.nextInt();
        TestUser user1=new TestUser();
        user1.age(age);
    }

    public void age(int age) throws AgeException {
        if (age < 0 || age > 130) {
            throw new AgeException("年龄不正常！");
        } else {
            user.setAge(age);
        }
    }
}

package com.wisezone.oop.seven;

import com.wisezone.oop.seven.exception.AgeException;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 15:21
 * @注释:个人
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    //声明自定义年龄异常
    public void setAge(int age) throws AgeException {
        if (age < 1 || age > 100) {
            //抛出异常
            throw new AgeException("年龄必须在1~100之间");
        } else {
            this.age = age;
        }

    }
}

package com.wisezone.oop.seven.test;

import com.wisezone.oop.seven.Person;
import com.wisezone.oop.seven.exception.AgeException;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 15:27
 * @注释:
 */
public class TestPerson {
    public static void main(String[] args) throws AgeException {
        Person person = new Person();
        person.setAge(0);
    }
}

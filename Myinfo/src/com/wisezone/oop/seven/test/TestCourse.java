package com.wisezone.oop.seven.test;

import com.wisezone.oop.seven.Course;
import com.wisezone.oop.seven.exception.SerialException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 16:47
 * @注释:
 */
public class TestCourse {
    public static void main(String[] args) throws SerialException {
        Scanner input = new Scanner(System.in);
        Course course = new Course();
        try {
            System.out.print("请输入课程代号(1~3之间的数字):");
            int serial = input.nextInt();
            course.setSerial(serial);
        } catch (InputMismatchException e) {
            System.err.println("请输入整型数字");
        } finally {
            System.out.println("欢迎提出建议");
        }
    }
}

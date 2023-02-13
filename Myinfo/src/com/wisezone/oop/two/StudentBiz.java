package com.wisezone.oop.two;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 11:25
 * @注释:
 */
public class StudentBiz {
    //对象数组
    Student[] students = new Student[5];

    /**
     * 添加学生对象
     *
     * @param stu
     */
    public void addStu(Student stu) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = stu;
                break;
            }
        }
    }

    /**
     * 显示学生对象
     */
    public void showStu() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                students[i].showInfo();
            }
        }
    }
}

package com.qfedu.gather.collection.list;

/**
 * @Author: XIYAN
 * @Date: 2023/1/10 17:59
 * @注释:学生
 */
public class Student /*implements Comparable<Student> */ {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 先按姓名比较，然后再按年龄比较
     *
     * @param o the object to be compared.
     * @return
     */
//    @Override
//    public int compareTo(Student o) {
//        int num1 = getName().compareTo(o.getName());
//        int num2 = getAge() - o.getAge();
//        return num1 == 0 ? num2 : num1;
//    }
}

package com.wisezone.oop.four;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 9:36
 * @注释:
 */
public class Student {
    private String id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    /**
     * 重写equals
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        //1.对象内存地址相等true
        if (this == object) {
            return true;
        }
        //2.参数为空false
        if (object == null) {
            return false;
        }
        //3.参数强转，比较学号和姓名相等true
        //instanceof判断是否有继承和实现关系，判断是否是同一对象
        if (object instanceof Student) {
            //向下转型
            Student student = (Student) object;
            //非空和值相等判断
            if ("".equals(student.id) || student.id == null || "".equals(student.name) || student.name == null) {
                return false;
            }
            //值相等判断
            if (student.id.equals(this.id) && student.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 重写hashcode
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.id == null ? 0 : id.hashCode());
        result = 31 * result + (this.name == null ? 0 : name.hashCode());
        return result;
    }
}

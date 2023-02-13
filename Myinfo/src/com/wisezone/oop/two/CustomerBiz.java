package com.wisezone.oop.two;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 10:11
 * @注释:
 */
public class CustomerBiz {
    String[] names = new String[30];

    /**
     * 添加客户姓名
     *
     * @param name
     */
    public void addName(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                names[i] = name;
                break;
            }
        }
    }

    /**
     * 修改（更新）客户姓名
     *
     * @param oldName
     * @param newName
     * @return
     */
    public boolean editName(String oldName, String newName) {
        boolean flag = false;
        for (int i = 0; i < names.length; i++) {
            if (oldName.equals(names[i])) {
                flag = true;
                names[i] = newName;
                break;
            }
        }
        return flag;
    }

    /**
     * 查找客户姓名
     *
     * @param start
     * @param end
     * @param name
     * @return
     */
    public boolean searchName(int start, int end, String name) {
        boolean flag = false;
        if (start == 1) {
            start = 0;
        }
        for (int i = start; i < end; i++) {
            if (name.equals(names[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 显示客户姓名
     */
    public void showNames() {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.print(names[i] + "\t");
            }
        }
    }
}

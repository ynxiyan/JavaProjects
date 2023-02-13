package com.wisezone.oop.seven;

import com.wisezone.oop.seven.exception.SerialException;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 16:40
 * @注释:课程名称
 */
public class Course {
    private int serial;

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) throws SerialException {
        if (serial >= 3 || serial < 0) {
            throw new SerialException("序号必须在1~3之间");
        } else {
            this.serial = serial;
            System.out.println("C#编程");
        }
    }
}

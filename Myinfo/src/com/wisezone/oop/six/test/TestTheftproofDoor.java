package com.wisezone.oop.six.test;

import com.wisezone.oop.six.TheftproofDoor;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 9:49
 * @注释:
 */
public class TestTheftproofDoor {
    public static void main(String[] args) {
        TheftproofDoor theftproofDoor = new TheftproofDoor();
        theftproofDoor.photo();
        theftproofDoor.openLock();
        theftproofDoor.open();
        theftproofDoor.close();
        theftproofDoor.lockUp();
    }
}

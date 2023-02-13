package com.wisezone.synthesis.test;

import com.wisezone.synthesis.FileReadAndWriter;

import java.io.*;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 10:41
 * @注释:
 */
public class TestIO {
    public void testDataStream() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            fis = new FileInputStream(new File("D:/XIYAN/Pictures/Screenshots/屏幕截图 2022-11-08 085119.png"));
            dis = new DataInputStream(fis);
            fos = new FileOutputStream(FileReadAndWriter.picPath);
            dos = new DataOutputStream(fos);
            int temp;
            while ((temp = dis.read()) != -1) {
                dos.write(temp);
            }
            dos.flush();
            System.out.println("图片复制成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (dis != null) {
                dis.close();
            }
            if (dos != null) {
                dos.close();
            }
        }
    }
}

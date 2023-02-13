package com.wisezone.features.there;

import java.io.File;
import java.io.IOException;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 14:38
 * @注释:文件操作
 */
public class FileOperation {
    /**
     * 创建文件
     *
     * @param file
     */
    public void createFile(File file) {
        //判断当前路径文件是否存在
        if (!file.exists()) {
            //创建一个空文件<里面没有内容>
            try {
                file.createNewFile();
                System.out.println("创建文件成功。");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            //创建文件夹<注意不是百分百成功>
            file.mkdirs();
        }
    }

    /**
     * 删除文件
     *
     * @param file
     */
    public void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
            System.out.println("删除文件成功！");
        }
    }

    /**
     * 读取文件
     *
     * @param file
     */
    public void readFile(File file) {
        if (file.exists()) {
            System.out.println("是一个文件吗？" + file.isFile());
            System.out.println("是一个目录吗？" + file.isDirectory());
            System.out.println("文件的绝对路径是：" + file.getAbsolutePath());
            System.out.println("文件的相对路径是：" + file.getPath());
            System.out.println("文件名是：" + file.getName());
            System.out.println("文件大小是：" + file.length() + "字节");
        } else {
            System.out.println("文件没有找到！！");
        }
    }
}

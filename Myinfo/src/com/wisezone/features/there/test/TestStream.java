package com.wisezone.features.there.test;

import com.wisezone.features.two.FileReadAndWriter;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 15:27
 * @注释:IO流
 */
public class TestStream {
    /**
     * 字节流
     * 文件输入输出流来读写文件
     */
    @Test
    public void testFileStream() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //读取文件内容到fis对象
            fis = new FileInputStream(new File(FileReadAndWriter.outPath));
            //写入文件内容到fos对象
            fos = new FileOutputStream(new File(FileReadAndWriter.path));
            //创建字节中转站数组，用来临时存放数据
            byte[] words = new byte[1024];
            //循环读取并写入
            //不等于-1时代表还有内容
            while (fis.read() != -1) {
                fis.read(words);
                fos.write(words, 0, words.length);
            }
            System.out.println("文件读写成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流对象
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fis.close();
            }
        }
    }

    /**
     * 字符流
     *
     * @throws IOException
     */
    @Test
    public void testFileReadStream() throws IOException {
        Reader rd = null;
        Writer wt = null;
        StringBuffer sb = new StringBuffer();
        try {
            rd = new FileReader(new File(FileReadAndWriter.path));
            wt = new FileWriter(new File(FileReadAndWriter.namePath));
            char[] words = new char[1024];
            //将字符读入数组
            int lh = rd.read(words);
            while (lh != -1) {
                sb.append(words);
                lh = rd.read();
            }
            //写入文件
            wt.write(sb.toString());
            //刷新缓冲区
            wt.flush();
            System.out.println("文件读写成功！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流对象
            if (rd != null) {
                rd.close();
            }
            if (wt != null) {
                wt.close();
            }
        }
    }

    /**
     * 字符缓冲流读写模块文件
     */
    @Test
    public void testBufferReadStream() throws IOException {
        Reader rd = null;
        Writer wt = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            rd = new FileReader(new File(FileReadAndWriter.outPath));
            br = new BufferedReader(rd);
            wt = new FileWriter(new File(FileReadAndWriter.nameOutPath));
            bw = new BufferedWriter(wt);
            StringBuffer sb = new StringBuffer();
            String len = "";
            //循环读取追加sb
            while ((len = br.readLine()) != null) {
                sb.append(len);
            }
            System.out.println("读取到的模板原内容是：\n" + sb);
            String newStr = sb.toString();
            //链式调用
            newStr = newStr.replace("{teacher}", "王老师")
                    .replace("{content}", "身体不舒服")
                    .replace("{day}", "2")
                    .replace("{name}", "xxx")
                    .replace("{yyyy}", "2023")
                    .replace("{MM}", "01")
                    .replace("{dd}", "30");
            System.out.println("替换后的内容：\n" + newStr);
            //写入文件
            bw.write(newStr);
            //刷新缓冲区
            bw.flush();
            System.out.println("文件内容替换成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流对象
            if (rd != null) {
                rd.close();
            }
            if (wt != null) {
                wt.close();
            }
            if (br != null) {
                br.close();
            }
            if (bw != null) {
                bw.close();
            }
        }
    }

    /**
     * 数据流复制图片
     */
    @Test
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
            //声明一个临时变量存储
            int temp;
            //循环读取并写入
            while ((temp = dis.read()) != -1) {
                dos.write(temp);
            }
            //刷新缓存区
            dos.flush();
            System.out.println("图片复制成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流对象
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

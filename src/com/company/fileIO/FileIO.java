package com.company.fileIO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.Paths;

public class FileIO {
    public static void main(String[] args) {
        testFileInput();
        testFileOut();
    }

    private static void testFileInput() {
        // 获取jvm启动路径 System.getProperty("user.dir")
        System.out.println(System.getProperty("user.dir")); // F:\codingSpace\java\studyNotes

        try{
            // Scanner构造器如果接受一个字符串做参数,会把这个字符串当作数据输入
            Scanner fsi = new Scanner(Paths.get("src/com/company/fileIO/input.txt"), "utf-8");
            System.out.println(fsi.nextLine()); // 测试文件输入ok!
        }  catch (IOException ioe) {
            System.out.println("文件找不到");
            ioe.printStackTrace();
        }
    }

    private static void testFileOut() {
        try {
            PrintWriter fw = new PrintWriter("src/com/company/fileIO/output.txt", "utf-8");
            fw.println("测试文件输出ok!");
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}

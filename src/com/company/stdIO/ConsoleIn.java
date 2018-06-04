package com.company.stdIO;

import java.io.Console;

public class ConsoleIn {
    public static void main(String[] args) {
        testConsoleIn();
    }

    private static void testConsoleIn() {
        // 需要从控制台输入密码时使用Console类
        // Idea Eclipse等IDE的stdIn和stdOut被重定向了,jvm有可能获取不到console,导致cs为null
        try {
            Console cs = System.console();
            System.out.println("You enter the password: " + cs.readLine("Enter the pwd: "));
            char[] pwd = cs.readPassword("pwd: ");
            //  使用完pwd后应该用新的值覆盖pwd,提醒jvm回收
            pwd = null;
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

    }
}

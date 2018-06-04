package com.company.stdIO;

import java.util.Scanner;

public class StdIn {
    public static void main(String[] args) {
        testStdIn();
    }

    private static void testStdIn() {
        // 先定义一个扫描器
        Scanner stdIn = new Scanner(System.in);

        // 输入    hello    world
        System.out.println(stdIn.next()); // hello 去除输入前面的空白
        System.out.println(stdIn.hasNext()); // hasNext只会检测字符输入,不会从输入流取出数据
        stdIn.nextLine();
        // 不给机会输入
        System.out.println(stdIn.nextLine()); //     world 空白符之后的输入作为nextLine输入
        // 上面这种next,nextLine连起来的情况即便第一次输入字符后面只有一个空格也会跳过nextLine
        // 要解决上面的问题只需要在正确输入的语句前加一句nextLine抵消掉没用的输入

        // nextInt, nextDouble,等也有上面的问题
        System.out.println(stdIn.nextDouble());
        stdIn.nextLine();
        System.out.println(stdIn.nextLine());

//        System.out.println(stdIn.nextBoolean());
//        System.out.println(stdIn.nextInt());

//        System.out.println(stdIn.nextBigInteger());
//        System.out.println(stdIn.hasNext());
//        System.out.println(stdIn.hasNextInt());
    }

}

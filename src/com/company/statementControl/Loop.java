package com.company.statementControl;

import java.util.Scanner;

/**
 * 循环语句
 */
public class Loop {
    public static void main(String[] args) {
        // testWhile();
        // doWhile();
        // testFor();
        testSpeed();
    }

    /**
     * while循环
     */
    private static void testWhile() {
        // while每次执行循环体前都要进行判断,有可能一次也不执行
        while (System.currentTimeMillis() % 5 < 2) {
            System.out.println("Current timeStamp is even");
        }
    }

    private static void doWhile() {
        Scanner in = new Scanner(System.in);
        // 循环需要至少执行一次的情况用do while,do while语句最后有一个分号
        do{
            String instruction = in.nextLine().trim();
            if (instruction.equals("run")) {
                System.out.println("run..........");
            } else {
                System.exit(0);
            }
        } while(true);
    }

    private static void testFor() {
        // 计数器式for循环
        for (int i = 1; i < 5; ++i) {
            System.out.println((char)('a' + i));
        }

        // 循环判断部分可以定义多个同类型变量
        // 增量部分可以用逗号隔开多条语句
        for (int i = 0, j = 1; i < 3; ++i, j++, System.out.println(i + "次循环")) {
            System.out.println(i + j);
        }

        // 循环条件有浮点数要注意不能使用==和!=判断
        // 由于浮点数精度问题,可能会陷入死循环,永远不可能==,!=
        // 下面的就会死循环
        // 应该使用误差判断
//        for (double d = 9.9; d != 0; d -= 3.3) {
//            System.out.println(d);
//        }

        // 其实有for循环没必要while循环,反过来说也一样
        for (; ;) {
            System.out.println("死循环");
        }
    }

    private static void testSpeed() {
        long start = System.currentTimeMillis();
        {
            Student stu = new Student();
            for (int i = 0; i < 10_0000_0000; ++i) {
                stu.setName("ly");
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("Variable outOf loop body cost: %d%n", end - start); // Variable outOf loop body cost: 79

        start = System.currentTimeMillis();
        {
            for (int i = 0; i < 10_0000_0000; ++i) {
                Student stu = new Student();
                stu.setName("ly");
            }
        }
        end = System.currentTimeMillis();
        System.out.printf("Variable in loop body cost: %d%n", end - start); // Variable in loop body cost: 3
    }
}

class Student{
    String name = "";
    int age = 10;

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    String addr = "xxxx";



}

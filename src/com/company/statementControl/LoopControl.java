package com.company.statementControl;

import java.util.Scanner;

/**
 * java中goto作为保留字,没有goto语句,但是有可以带标签的break和continue
 * break和continue不是必不可少的,一般改写程序就可以去掉break和continue
 * 有些大牛建议程序不要使用break和 continue
 */
public class LoopControl {
    public static void main(String[] args) {
        // testBreak();
        breakTag();
        testContinue();
    }

    private static void testBreak() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().trim();
            if (input.equals("q")) {
                break;
            } else {
                System.out.println("You input " + input);
            }
        }

        // 上面例子改写
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();
        while(!input.equals("q")) {
            System.out.println("You input " + input);
        }
        // 有时候改写起来挺别扭,这时还是直接用break好了
    }

    private static void breakTag() {
        for (int i = 0, flag = 1; i < 1000; ++i) {
            if (flag == 0) {
                break;
            }
            for (int j = 0, flag1 = 1; j < 1000; ++j) {
                if (flag1 == 0) {
                    flag = 0;
                    break;
                }
                for (int k = 0; k < 1000; ++k) {
                    if (i == 666 && j == 888 && k == 999) {
                        flag1 = 0;
                        System.out.printf("%d,%d,%d%n", i, j, k);
                        break;
                        // break后面的语句无效
                        // 想要直接出多重循环不方便
                    }
                }
            }
        }

        outer:
        for (int i = 0, flag = 1; i < 1000; ++i) {
            for (int j = 0; j < 1000; ++j) {
                for (int k = 0; k < 1000; ++k) {
                    if (i == 666 && j == 888 && k == 999) {
                        System.out.printf("%d,%d,%d%n", i, j, k);
                        break outer;
                        // break后面的语句无效
                        // 想要直接出多重循环不方便
                    }
                }
            }
        }

        // 事实上break可以在任何地方使用,但是标签必须体在语句块前面
        // 格式为:TagName:
        tag:
        {
            System.out.println("here!!!");
            if (true) {
                break tag;
            }
        }
    }

    private static void testContinue() {
        int index = 0;
        while(index != 5) {
            System.out.println("Into loop");
            index = 5;
            continue; // 调到循环首部index != 5
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int input = new Scanner(System.in).nextInt();
            if (input < 0) {
                continue;
            }
            sum += input;
        }
        System.out.println(sum);

        // 改写上面例子,去掉continue
        sum = 0;
        for (int i = 0; i < 3; i++) {
            int input = new Scanner(System.in).nextInt();
            if (input >= 0) {
                sum += input;
            }

        }
        System.out.println(sum);

    }
}

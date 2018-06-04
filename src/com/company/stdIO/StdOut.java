package com.company.stdIO;

public class StdOut {
    public static void main(String[] args) {
        testStdOut();
    }

    private static void testStdOut() {
        // c语言的格式化输出
        System.out.printf("I'm %s\n", "ly"); // I'm ly

        // .号前面的数字表示整个打印值的宽度,包括小数点
        System.out.printf("%9.2f\n", 11111.22f); // =>  11111.22

        // 转换符
        System.out.printf("%d,%f,%s\n", 22333, 6.75, "哈哈哈哈"); // 22333,6.750000,哈哈哈哈
        System.out.printf("%x,%o,%e\n", 16, 8, 123.06); // 10,10,1.230600e+02
        System.out.printf("%b%c%n", 100, 'x'); // truex %n换行符,平台相关
        String str1 = "abc";
        String str2 = "abc";
        System.out.printf("%h%n", str1); // 17862
        System.out.printf("%h%n", str2); // 17862
    }
}

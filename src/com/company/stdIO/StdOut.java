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

        // 转换符 %s可以打印任何对象
        // 如果对象实现了Formattable接口将调用formatTo方法,否者调用toString
        System.out.printf("%d,%f,%s\n", 22333, 6.75, "哈哈哈哈"); // 22333,6.750000,哈哈哈哈
        System.out.printf("%x,%o,%e\n", 16, 8, 123.06); // 10,10,1.230600e+02
        System.out.printf("%b%c%n", 100, 'x'); // truex %n换行符,平台相关
        String str1 = "abc";
        String str2 = "abc";
        System.out.printf("%h%n", str1); // 17862
        System.out.printf("%h%n", str2); // 17862

        // 标志 在格式说明名符的%后面
        // 正负号
        System.out.printf("%+d,%+d,%+d%n", 1, -1, 0); // +1,-1,+0
        // 空格标志,和默认的一样
        System.out.printf("%8d%n", 12345); //    12345
        System.out.printf("% 8d%n", 12345); //    12345
        // 0标志
        System.out.printf("%08d%n", 12345); // 00012345
        // - 左对齐
        System.out.printf("%-8d%n", 12345); // 12345   ,
        // ( 将负数括在括号内
        System.out.printf("%(d,%(d,%(d%n", 1, -1, 0); // 1,(1),0
        // , 分组,中国人的习惯是4个位,老外是3位
        System.out.printf("%,d%n", 1_0000_0000); // 100,000,000
        // # 包含小数点(对于f转换符) 包含0x或0(对于x或o转换符)格式
        System.out.printf("%#f%n", 3.0); // 3.000000
        System.out.printf("%#x%n", 16); // 0x10
        System.out.printf("%#o%n", 8); // 010
    }
}

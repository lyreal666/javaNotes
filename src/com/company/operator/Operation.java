package com.company.operator;

public class Operation {
    public static void main(String[] args) {
        testTypeConversion();
    }

    /**
     * 类型转换
     */
    private static void testTypeConversion() {
        // 总的原则: 不同类型数据进行运算要转换成同一种数据类型
        // 一般性原则: 两个数进行运算
        /*
         * 1. 有浮点型数据,非浮点型数据转浮点型数据,long => float
         * 2. 小的数据类型转大的数据类型byte => short => int => long,float => double,char => int
         * 3. 小的转大的没有精度的丢失,大转小,有可能
         */
        float r = 1 + 0.5F; // int型1自动转换成float
        System.out.println(r);

        // 一般小转大的没有精度丢失,有时候会自动转换，又称作隐式类型转换,
        // 大的数据类型转小的默认是不允许的,编译会报错
        // int intVar = 6666L;报错
        // Error:(24, 22) java: 不兼容的类型: 从long转换到int可能会有损失

        // 可以使用强制类型转换实现int转long
        // 格式为在需要转换的操作数前面用圆括号括起来你要转换的结果类型
        int intvar = (int)6666L; // 编译通过

        // 浮点型转整形,直接砍掉尾数部分
        System.out.println((int)6.75); // 6
        // 如果四舍五入取约数
        System.out.println(Math.round(6.75)); // round()返回long类型

        // 看看被转换书超出要转换的数据类型范围的情况,直接减去最大范围
        System.out.println((byte)300); // 44, 44 = 300 - 256
    }
}

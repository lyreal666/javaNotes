package com.company.operator;

import static java.lang.Math.*;

public class Operation {
    public static void main(String[] args) {
        testTypeConversion();
        testOperator();
        testPrime();
        testEnum();
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

    private static void  testOperator() {
        // 赋值运算符
        int intVar = 0;
        intVar += 3.5; // 实际上是intVar = int(intVar + 3.5); 自动强制类型转换

        // 经典题
        int count = 0;
        for (int i = 0; i < 100; ++i) {
            count = count++;
        }
        System.out.println(count); // 0
        // 原因:
        /*
        int autoAdd(int count) {
            int temp = count;
            count += 1;
            return temp;
        }
         */

        // 注意:使用自增自减运算符一方面难以理解,另一方面容易出错,所以建议只在以下两种情况使用
        // 1. for循环
        // 2. 单行的情况

        // 关系运算符
        /*
        >,<,=,>=,<=,!=,大多数操作符只支持值类型
        ==, !=可以支持所有对象,比较的是地址
        String类型支持+=,+
         */

        // 逻辑操作符&,|,&&,||，后两个是短路操作符
        // 使用短路逻辑好处在于,
        // 1. 不用执行后面无用判断
        // 2. 有时候非短路逻辑操作继续执行第二个判断会出错,
        // 因为第二个判断是基于第一个判断不成立的情况才需要判断

        int x = 0;
        int y = 1;
        boolean bool = x != 0 && 1 / x > x + y;

        // java中的条件运算符
        System.out.println(false ? 1 : 2); // 2

        // 位运算
        // &(and) |(or) ^(xor) ~(not)
        // 有位运算可以使用掩码技术得到一个数的二进制形式的某一位
        int j = 0b10101010;
        int bit2 = (0b10 & j) / 0b10;
        System.out.println(bit2); // 1 原数第二位是1

        // 位移动运算符
        int fourBitFromRight = (1 << 3 & j) >> 3;
        System.out.println(fourBitFromRight); // 1 原数第四位是1

        // >>> 会使得符号为0,即元算结果是正数
        // -1补码11111111111111111111111111111111
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(0B11111111111111111111111111111111 >> 1); // -1
        System.out.println(0B11111111111111111111111111111111 >>> 1); // 2147483647
    }

    /**
     *
     */
    private static void testPrime() {
        /*
        比较值得注意的是:
        1. 位运算优先级普遍低于+-运算
        2. ？运算符从右边计算到左边
        3. 记住自增自减运算符优先级很高
         */
        System.out.println(3 + 2 << 2); // 20
        int rs = 2 < 3 ? 6 < 7 ? 6 : 7 : 8; // 从右边计算到左边
        System.out.println(rs);;
    }


    enum Season {
        Sprinig,
        Summer,
        Autumn,
        Winter
    }
    /**
     * 枚举类型
     */
    private static void testEnum() {
        Season season = Season.Sprinig;
        System.out.println(season); // Spring
        System.out.println(Season.Autumn);// Autumn
    }
}

/**
 * 运算符和Math
 */

class TestMath{
    public void test() {
        // c系的java支持的运算符也很少
        int x = 1;
        int y = 2;
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / y);
        System.out.println(x % y); // 求模运算

        // int r = x / 0; 会有运行时异常
        // java.lang.ArithmeticException: / by zero

        double r = 0.5 / 0;
        System.out.println(r); // Infinity

        short svar = 1;
        int vari = svar + 2;
        // svar = vari + 2; // 短整形和长整形运算短整形自动转换长整形运算
        // 上面报错 Error:(74, 21) java: 不兼容的类型: 从int转换到short可能会有损失

        /*
        由于不同的机器浮点寄存器位数不一样,为了实现可移植性,有两种做法
        1. 严格按照先截取64位再参与运算,通过类修饰符strictfp实现
        2. 默认:允许机器使用扩展指数位
        区别:后者由于位数更多不容易溢出
         */

        // 数学函数,使用静态导入来使用类里面的静态方法
        // 大多数数学函数返回double类型结果
        System.out.println(sqrt(4)); // 求平方根
        System.out.println(pow(2, 3)); // 求幂
        System.out.println(floorMod(17, 10)); // 求模运算
        // 三角函数
        System.out.println(sin(30 * PI / 180));
        System.out.println(cos(60 * PI / 180));
        System.out.println(tan(60 * PI / 180));
        System.out.println(atan(1));
        // 指数运算和对数运算
        System.out.println(exp(1));
        System.out.println(log(exp(1)));
        System.out.println(log10(100));
        // 一些数学常数
        System.out.println(PI);
        System.out.println(E);

        // 还有一个StrictMath类,使用它的数学函数得到的数据是跨平台的,完全可预测的
    }
}

package com.company.variable;
import static java.lang.Math.*;


/**
 * 变量
 */
public class Variable {
    public static void main(String[] args) {
        // 有效的变量名必须是$,_,字母开头,由字母,数字,下划线,美元符号组成
        // int 6p = 666; // 数字开头不合法
        int $var = 666;
        int _var = 888;
        int var = 999;


        // java中变量没有初始化不能使用
        int variable;
        // System.out.println(variable); // 报错可能尚未初始化

        // 允许连续声明多个变量
        int vara, varb;
        int varc = 1, vard = 2;
        // int vare, varf = 1, 2; // 报错,编译器2这个标识符不合法
        int varg, varh = 3, vari;
        // 但是连续声明变量影响可读性,建议分行写
        int var1;
        int var2;

        // 变量应该尽量什么时候使用什么时候声明,这是一种良好的编程风格

        /*
        分析一下变量声明以及定义过过程发生了什么
        int variable;
        执行上面的声明语句,就在桟空间分配了一个变量variable,此时已经安装variable是int类型分配了4个字节大小
        预留空间

        variable = 1;
        修改预留空间为1
         */


    }
}


/**
 * 常量
 */
class ConstVariable {
    // 定义一个类常量-用final修饰的类变量,如果没有static,叫实例变量
    public static final double CONSTANT = 6.75;

    public void test() {
        // 使用final定义常量,定义常量建议全用大写字母,更加醒目
        double PI = 3.141592654;
        // java里面const是保留字
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
        System.out.println(sin(30));
        System.out.println(cos(60));
        System.out.println(tan(60));
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

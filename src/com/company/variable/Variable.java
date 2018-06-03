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


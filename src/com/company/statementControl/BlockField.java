package com.company.statementControl;

/**
 * 使用一对花括号定义一个语句块
 */
public class BlockField {
    public static void main(String[] args) {
        String mainFunc = "main";
        {
            System.out.println(mainFunc);
            String outer = "outer";
            {
                System.out.println(mainFunc);
                System.out.println(outer);
                String inner = "inner";
                System.out.println(inner);

                // 注意内层块不能定义和外层块同名变量,这在c++是允许的
                for (int i = 0; i < 10; ++i) {
//                    for (int i = 0; i < 10; ++i) {
//                        System.out.println(i);
//                    }
                    // Error:(20, 30) java: 已在方法 main(java.lang.String[])中定义了变量 i
                }

            }
        }
    }
}

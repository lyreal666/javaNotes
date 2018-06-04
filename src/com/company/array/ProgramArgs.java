package com.company.array;

import java.util.Arrays;

public class ProgramArgs {
    public static void main(String[] args) {
        //  和有些编程语言不一样args第一个参数不是文件名,而是真正的参数
        // 程序启动命令 java ProgramArgs.class ly is cool!
        System.out.println(Arrays.toString(args)); // [ly, is, cool]
    }
}

package com.company.array;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        testArray();
    }

    private static void testArray() {
        // 数组是一种物理上连续排列的数据结构
        // 声明一个数组,桟空间申请了变量arr
        int[] arr; // 也可以int arr[]
        // 初始化arr 堆内存申请10个连续int大小的空间,全部默认初始化为0
        arr = new int[10]; // 下标0~9
        System.out.println(arr[9]); // 0

        // 赋值
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
        System.out.println(arr[9]); // 9

        boolean[] bArr = new boolean[2];
        System.out.println(bArr[0]); // false boolean默认初始化为false

        String[] strArr = new String[12];
        System.out.println(strArr[11]); // null 对象数组默认赋值null
        System.out.println(strArr[0] == strArr[1]); // true null应该是单例模式

        try {
            // 越界访问报异常
            // java.lang.ArrayIndexOutOfBoundsException: 10
            // 这在c,c++是一点反应都没有的,java不允许不安全的内存访问
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
//            aioobe.printStackTrace();
        }

        // 数组长度length,而字符串要用length函数,为什么不也设计为属性?
        System.out.println(arr.length); // 10

        // 数组是长度不可变的,这和c/c++是一样的

        // 初始化
        // 推荐的方式
        int[] array = {1, 2, 3, 4, 5};
        // 测试,花括号表示的数组只有在初始化可用
        int[] iarray;
        // iarray = {1, 2, 3, 4}; // 语法错误
        // 可以使用匿名数组初始化，就不需要额外定义一个变量
        iarray = new int[]{1, 2, 3, 4};
        // 上面一行等效于
        /*
        int[] anonymous = {1, 2, 3, 4}
        iarray = anonymous;
        */

        // java允许数组长度为0
        /*
        这在设计函数时候如果返回值类型为数组,而且结果个数为0时很有用
        注意: 数组长度为0和null不是一个东西
         */
        int[] elements = new int[0];

        // 打印数组的方便方法
        System.out.println(arr); // [I@4554617c
        System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        // 数组是引用类型
        int[] array1 = {1, 2, 3};
        int[] array2 = array1;
        System.out.println(array1[0]); // 1
        System.out.println(array2[0]); // 1
        array1[0] = 4;
        System.out.println(array2[0]); // 4

        // 拷贝数组
        array2 = Arrays.copyOf(array1, array1.length);
        array1[0] = 1;
        System.out.println(array2[0]); // 4

        // Array.copy还可以用来扩充原数组
        int[] doubleArray1 = Arrays.copyOf(array1, 2 * array1.length);
        System.out.println(doubleArray1[array1.length]); // 0 多余元素默认值和默认初始化数组一样
    }
}

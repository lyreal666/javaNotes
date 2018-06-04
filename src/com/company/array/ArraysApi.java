package com.company.array;

import java.util.Arrays;

public class ArraysApi {
    public static void main(String[] args) {
        testApis();
    }

    /**
     * 测试数组的Api
     */
    private static void testApis() {
        char[] charArray = {'a', 'B', 'c'};
        int[] intArray = {2, 1, 11};

        // 按增删改查的顺序

        // toString 方便打印数组
        System.out.println(charArray); // aBc
        System.out.println(intArray); // [I@4554617c
        System.out.println(Arrays.toString(charArray)); // [a, B, c]
        System.out.println(Arrays.toString(intArray)); // [2, 1, 11]

        // copy,copyOfRange 对原数组拷贝或扩容,后者更灵活
        int[] intArrayOfCopy = Arrays.copyOf(intArray, intArray.length);
        System.out.println(intArrayOfCopy[2]); // 11
        char[] doubleCharArray = Arrays.copyOfRange(charArray, 0, 2 * charArray.length);
        System.out.println('a' + 1); // 98
        System.out.println(doubleCharArray[charArray.length] + 1); //
        System.out.println((char)0 == doubleCharArray[charArray.length]); // true
        // 说明char[]默认初始化值是ascall码值为0的字符

        // 数组是不可以删除的

        // fill 填充,和js的fill一样,返回填充后的数组
        boolean[] flags = new boolean[10];
        Arrays.fill(flags, true);
        Arrays.fill(flags, 5, flags.length, false);
        System.out.println(flags[4]); // true
        System.out.println(flags[5]); // false

        // 搜索
        // 二分搜索
        System.out.println(Arrays.binarySearch(intArray, 11)); // 2
        System.out.println(Arrays.binarySearch(intArray, 1, intArray.length, 11)); // 2
        // 排序 sort
        // 使用优化过的快速排序
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        // [1, 2, 11] 不像js一样默认按位排序

        // equals
        // 数组大小相等而且相同位置元素值相等
        // 参数类型为8中基本类型数组
        int[] arrayCopy = Arrays.copyOf(intArray, intArray.length);
        System.out.println(arrayCopy == intArray); // false
        System.out.println(Arrays.equals(arrayCopy, intArray)); // true
    }
}

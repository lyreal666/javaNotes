package com.company.array;

import java.util.Arrays;

public class NDimensionArray {
    public static void main(String[] args) {
        nDArray();
    }

    /**
     * 多维数组
     */
    private static void nDArray() {
        /*
        总结:
        一维数组是内存连续的
        一维数组元素是值或对象
        二维数组元素是一维数组的引用(指针)
        三维数组元素是二维数组的引用
        类推。。。
        n dimensions array is make up of n -1 dimensions array

        java 中多维数组类似于c/c+=动态内存分配
        int[][] twoDArray = new int[6][7];
        等于c/c++中int** twoDArray = new int*[6];
        也就是说多维数组元素指向的数组是指针的数组
        并且7个元素的数组之间不是连续的
         */

        // 体会下面代码
        // 不规则数组
        int[][] ndarray = new int[6][7];
        int[] testArray = new int[8];
        Arrays.fill(testArray, 6);;
        ndarray[1] = testArray;
        System.out.println(ndarray[1][7]); // 6
        System.out.println(ndarray[0].length); // 7
        System.out.println(ndarray[1].length); // 8
    }
}

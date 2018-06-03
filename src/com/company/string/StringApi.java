package com.company.string;

import java.util.Arrays;
import java.util.Timer;

public class StringApi {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        String fBytesStr = "\uD842\uDFB7"; // 𠮷

        // charAt 给定位置的代码单元,也就是2字节字符
        System.out.println(str.charAt(1)); // b
        System.out.println(fBytesStr.charAt(0)); // ?

        // codePointAt(int index) 5
        System.out.println(str.codePointAt(0)); // 97
        System.out.println(str.codePointAt(1)); // 98
        System.out.println(fBytesStr.codePointAt(0)); // 134071

        // offsetByCodePoints(startIndex, cpCount) 返回从startIndex开始的第cpCount个码点的下标(索引)
        // 其实就是真正的第cpCount个字符的下标
        System.out.println((str + fBytesStr).offsetByCodePoints(0, 2)); // 2
        System.out.println((fBytesStr+ str + fBytesStr).offsetByCodePoints(0, 27)); // 28

        // str.compareTo(String others)
        // 对内部char数组相同下标位置按照字典排序,大于others返回负数,小于返回正宇,相等返回0
        // 可以用来判断值是否相等
        System.out.println(str.compareTo(str + "")); // 0
        System.out.println(str.compareTo("b")); // -1
        System.out.println(str.compareTo("cd")); // -2
        // 结论: 返回码点差

        // 为了遍历字符串码点 => intStream codePoints()
        System.out.println(Arrays.toString(str.codePoints().toArray()));
        // [97, 98, 99, 100, 10, ... , 114, 115, 116, 117, 118, 119, 120, 121, 122]
        System.out.println(Arrays.toString(("a" + fBytesStr).codePoints().toArray()));

        // new String(int[] cPCounts, int offset, int count)
        System.out.println(new String(new int[]{97, 134071}, 0, 2));

        // equals
        System.out.println(str != null && str.equals("")); // false

        // bool equalsIgnoreCase
        System.out.println(str.equalsIgnoreCase(str.toUpperCase())); // true

        // 字符匹配
        // startsWith
        System.out.println(str.startsWith("abcd")); // true
        // endsWith
        System.out.println(str.endsWith("xyz")); // true

        // 字符搜索,搜索对象可以是字符串也可以是码点,所有Index搜索函数都是返回从头部算起的下标
        System.out.println(str.indexOf("bc")); // 1
        System.out.println("abcd".indexOf("d", 2)); // 3设置起始点,提高效率
        System.out.println(str.indexOf(98)); // 1
        System.out.println(str.indexOf(102, 2)); // 5

        // 倒过来搜索
        System.out.println(str.lastIndexOf("y")); // 24
        // 其它三个同上

        // length 返回字符串长度
        System.out.println(str.length()); // 26

        // 返回码点数量,不成对的算一个,第二个参数为范围尾+1
        // 其实就是返回真实的字符个数
        System.out.println(fBytesStr.codePointCount(0, fBytesStr.length())); // 1
        System.out.println(fBytesStr.codePointCount(0, fBytesStr.length() - 1)); // 1

        // replace
        // 参数为CharSequence类型
        System.out.println(str.replace("abc", "Abc")); // Abcdefghijklmnopqrstuvwxyz

        // subString(start, end)
        // end = start + count, count = end - start
        System.out.println(str.substring(13)); // nopqrstuvwxyz
        System.out.println(str.substring(0, 2)); // ab

        // 大小写转换
        System.out.println("ly".toUpperCase()); // LY
        System.out.println("Ly".toLowerCase()); // ly

        // trim 去除字符串两边空白符
        System.out.println("    abc   ".trim().length()); // 3

        // join拼接
        System.out.println(String.join("-", "18", "5", "4")); // 18-5-4

        // concat比使用+效率高
        System.out.println("hello".concat("world")); // helloworld
    }
}

package com.company.string;

/**
 * 字符串
 */
public class TestString {
    public static void main(String[] args) {
        testString();
        testCodePoint();
    }

    private static void testString() {
        String str = "I'm a string";
        System.out.println(str);

        // 截子串
        String str1 = "hello world";
        String subStr = str1.substring(6);
        System.out.println(subStr);

        // 拼接
        String combineStr = "hello " + "world";
        System.out.println(combineStr);
        combineStr += "!";
        System.out.println(combineStr);
        // 当一个字符串和一个非字符串拼接时,非字符串会自动转换为字符串,包括对象

        // 拼接多个字符串
        System.out.println(String.join(",","a", "b", "c"));

        // java字符串是不可变的
        // System.out.println(combineStr[0]); 报错
        // Error:(31, 38) java: 需要数组, 但找到java.lang.String

        // 改变一个字符串是通过拼接实现的
        String source = "google";
        String modfiStr = source.substring(0, 1).toUpperCase() + source.substring(1);
        System.out.println(modfiStr); // Google
        System.out.println(source + "" == source); // false

        /*
        为什么字符串在java中被设计为不可变
        1. 不可变字符串的修改有一个拷贝拼接的过程,效率低
        2. 但是找工作有一个好处就是可以共享字符串
        3. 字符串要达到共享的目的就不允许直接修改字符串
        4. 往往引用字符串的情况更多,而不是修改
        5. 共享带来的高效率大于比拼接字符串的抵消率
         */

        // 字符串比较
        // ==
        System.out.println("---------------------------------");
        String strA = "abc";
        String strB = "abc";
        System.out.println(strA == strB); // true
        System.out.println(strA.equals(strB)); // true
        System.out.println(strA.compareTo(strB)); // 0

        System.out.println("---------------------------------");
        String strC = "ab" + "c";
        System.out.println(strA == strC); // true
        System.out.println(strA.equals(strC)); // true
        System.out.println(strA.compareTo(strC)); //

        System.out.println("---------------------------------");
        String strX = strA + "";
        System.out.println(strA == strX); // false
        System.out.println(strA.equals(strX)); // true
        System.out.println(strA.compareTo(strX)); //

        System.out.println("---------------------------------");
        String strD = strA.substring(0);
        System.out.println(strA == strD); // true
        System.out.println(strA.equals(strD)); // true
        System.out.println(strA.compareTo(strD)); // 0

        System.out.println("---------------------------------");
        String strE = strA.substring(1);
        String testBC = "bc";
        System.out.println(testBC == strE); // false
        System.out.println(strE.equals(testBC)); // true
        System.out.println(strE.compareTo(testBC)); // 0

        System.out.println("abc".equalsIgnoreCase("ABC"));

        // ==比较的是地址
        // compareTo 比较值
        // equalsTo默认也是比较地址,但是String类重写了这个方法

        // 空字符串与null
        // 检验是不是空串
        System.out.println("".length() == 0);
        System.out.println("not Empty" == "");;

        // 检验是不是null
        System.out.println("" == null);

        // 检验既不是null,也不是""
        System.out.println("abc" != null && "abc".length() != 0);
        // 上面的前后顺序不能改,改了的化检测是否为null，无意义，因为如果是null，null.length包异常
    }

    private static void testCodePoint() {
        // 求码点
        // length 返回代码单元数量,也就是utf-16的字节个数
        System.out.println("\uD842\uDFB7 length: " + "\uD842\uDFB7".length()); // 𠮷 length: 2
        System.out.println("\uD842\uDFB7".codePointCount(0, "\uD842\uDFB7".length())); // 1
        System.out.println("哈哈\uD842\uDFB7".codePointCount(0, "哈哈\uD842\uDFB7".length())); // 2
        // 求第i个码点的码值
        int index = "哈\uD842\uDFB7哈\uD842\uDFB7".offsetByCodePoints(0, 3);
        System.out.println(index); // 4
        System.out.println("哈\uD842\uDFB7哈\uD842\uDFB7".codePointAt(index)); //134071


        // 码点转字符
        // 求某个代码单元位置的字符
        System.out.println("哈哈\uD842\uDFB7".charAt(3)); // ? 打印出错，\uD800~\uE000保留码值
        System.out.println("哈哈\uD842\uDFB7".charAt(0)); // 哈

        // 遍历一个字符串的码值
        String strStr = "哈哈\uD842\uDFB7";
        int[] codePoints = strStr.codePoints().toArray();
        for (int i = 0; i < codePoints.length; ++i) {
            System.out.println(codePoints[i]);
        }
    }
}

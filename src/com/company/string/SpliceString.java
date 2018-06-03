package com.company.string;

/**
 * concat 比 + 效率高
 * java需要大量拼接字符窜时考虑用StringBuild,StringBuffer
 */
public class SpliceString {
    public static void main(String[] args) {
        speedTest();
        testBuilder();
    }

    private static void testBuilder() {
        StringBuilder sb = new StringBuilder(10_0000); // 指定容量为10_0000
        // 使用append往底层的动态char数组后面添加字符串
        sb.append("ly");
        sb.append(" ");
        sb.append("cool! ");
        // 使用toString或和构建器构造的字符串
        System.out.println(sb.toString()); // ly cool!

        // 可以拼接字符
        sb.append('6');
        System.out.println(sb.toString()); // ly cool! 6

        // 可以拼接字符
        sb.append(66);
        System.out.println(sb.toString()); // ly cool! 666

        // 可以拼接指定码点的字符
        sb.appendCodePoint(97);
        System.out.println(sb.toString()); // ly cool! 666a

        // 插入 insert
        sb.insert(12, ' ');
        System.out.println(sb.toString()); // ly cool! 666 a
        sb.insert(13, "999");
        System.out.println(sb.toString()); // ly cool! 666 999a

        // 删除
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString()); // ly cool! 666 999

        // 容量 满了就扩大到2倍加2
        System.out.println(sb.capacity()); // 100000
        StringBuilder sb1 = new StringBuilder();
        System.out.println(sb1.capacity()); // 16
        sb1.append("1234567891012345");
        System.out.println(sb1.capacity()); // 16
        sb1.append("123456789101234567");
        System.out.println(sb1.capacity()); // 34
        sb1.append("123456789101234567" + "123456789101234567");
        System.out.println(sb1.capacity()); // 70
    }

    private static void testBuffer(){
        // 是StringBuilder的前身
        // 是线程安全的,但效率比Builder低
    }

    private static void speedTest() {
        String result = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = result + 'a';
        }
        long end = System.currentTimeMillis();
        System.out.println("Test + cost time: " + (end - start)); // Test + cost time: 7405

        result = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = result.concat("a");
        }
        end = System.currentTimeMillis();
        System.out.println("Test concat cost time: " + (end - start)); // Test concat cost time: 2085

        result = "";
        StringBuilder sb = new StringBuilder(1_0000_0000);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_0000_0000; i++) {
            sb.append("a");
        }
        result = sb.toString();
        end = System.currentTimeMillis();
        System.out.println("Test StringBuilder[1_0000_0000] cost time: " + (end - start)); // Test StringBuilder[10_0000] cost time: 841

        result = "";
        StringBuilder sb1 = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_0000_0000; i++) {
            sb1.append("a");
        }
        result = sb1.toString();
        end = System.currentTimeMillis();
        System.out.println("Test StringBuilder[] cost time: " + (end - start)); // Test StringBuilder[] cost time: 1080

        result = "";
        StringBuffer sbf = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_0000_0000; i++) {
            sbf.append("a");
        }
        result = sbf.toString();
        end = System.currentTimeMillis();
        System.out.println("Test StringBuffer[]: " + (end - start)); // Test StringBuffer[]: 1434

        result = "";
        StringBuffer sbf1 = new StringBuffer(1_0000_0000);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_0000_0000; i++) {
            sbf1.append("a");
        }
        result = sbf1.toString();
        end = System.currentTimeMillis();
        System.out.println("Test StringBuffer[1_0000_0000]: " + (end - start)); // Test StringBuffer[1_0000_0000]: 1056
    }
}

package com.company.bigNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

// 大整型数
public class TestBigInteger {
    public static void main(String[] args) {
        BigInteger personNumber = BigInteger.valueOf(1_0000_0000);
        System.out.println(personNumber); // 100000000
        // 遗憾的是java并没有重载BigInteger的操作符,不能使用+,-,*,/
        BigInteger personNumberAfter10y = personNumber.multiply(BigInteger.valueOf(20));
        System.out.println(personNumberAfter10y); // 2000000000
        BigInteger personNumberSubtractMe = personNumber.subtract(BigInteger.valueOf(1));
        System.out.println(personNumberSubtractMe); // 99999999
        // 还可以使用add,divide,compareTo,mod(求模运算)
        BigInteger numberDvideBy3 = personNumber.divide(BigInteger.valueOf(3));
        BigInteger addOne = personNumber.add(BigInteger.valueOf(1));
        System.out.printf("%d,%d%n", numberDvideBy3, addOne); // 33333333,100000001

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i < 60; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
        //138683118545689835737939019720389406345902876772687432540821294940160000000000000
    }
}

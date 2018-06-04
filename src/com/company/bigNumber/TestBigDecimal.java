package com.company.bigNumber;

import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String args[]) {
        // BigDecimal.ROUND_HALF_UP四舍五入
        System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_UP)); // 0

        // 666 / 10 * 200的大实数
        System.out.println(BigDecimal.valueOf(666, 200)); // 6.66E-198
    }
}

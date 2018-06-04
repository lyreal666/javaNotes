package com.company.statementControl;

/**
 * 条件语句
 */
public class Condition {
    public static void main(String[] args) {
        singleConditon();
        conditionBranch();
        multiBranches("ly");
    }

    /**
     * 单条件
     */
    private static void singleConditon() {
        double yourSales = 1_2000.0;
        double target = 1_0000.0;

        // 使用块语句使得原本只能放一条语句的地方可以放多条语句
        if (yourSales > target) {
            System.out.println("Satisfactory...");
            System.out.println("To be more diligent");
        }
    }

    /**
     * 条件分支
     */
    private static void conditionBranch() {
        long now = System.currentTimeMillis();

        if (Math.floorMod(now, 2) == 0) {
            System.out.println("now is even");
        } else {
            System.out.println("now is odd");
        }

        // 悬挂else
        /*
        看起来只有等于0和不等于0两种情况
        理解这个错误要知道,else总是和最近的if分支绑定,除非最近的if分支已经else
         */
        if ((int)(Math.random() * 3) == 0)
            System.out.println("Random Int is 0");
            if ((int)(Math.random() * 3) == 1)
                System.out.println("Random Int is 1");
        else
            System.out.println("Random Int is not 0");
    }

    /**
     *多分枝条件语句
     * @param user
     */
    private static void multiBranches(String user) {
        if (user != null) {
            if (user.equals("ly")) {
                System.out.println("Welcome back ly...");
            } else if (user.equals("rookiess")) {
                System.out.println("Rokiess, welcome!");
            } else {
                System.out.println("Root account is dangerous!");
            }
        } else {
            System.out.println("User is null!");
        }
    }
}

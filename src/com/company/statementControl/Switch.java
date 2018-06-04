package com.company.statementControl;

/**
 * switch语句是为了解决有限个条件判断不够直观二,简洁出现的
 */
public class Switch {
    public static void main(String[] args) {
        testSwitch(args);
    }

    private static void testSwitch(String[] args) {
        // 除非你对switch语句有偏爱,否者建议别用switch
        /*
        一个分支没有break会fallthrough直到break或default结束
        switch 分支标签可以是:
        1. 整形,字符,常量表达式
        2. 枚举常量
        3. 字符串 se7开始

        如果使用switch建议编译时加上-Xlint:fallthrough选项,加上后如果某个分支缺少break,编译器会发出警告
        如果想局部不警告,可以在外围方法加上@SuppressWarnning("fallthrough")
         */
        switch (args[0]) {
            case "-g":
                System.out.println("Global");
            case "-dev":
                System.out.println("development");
                break;
            case "-i":
                System.out.println("install");
                break;
            default:
                System.out.println("helpInfo");
        }

        // 使用枚举常量做标签时不需要加枚举类名如: ACTION.SING,只需要SING就可以了
        Action action = Action.FLY;
        switch (action) {
            case RUN:
                System.out.println("Run...");
                break;
            case SING:
                System.out.println("Sing lostRivers..");
                break;
            case FLY:
                System.out.println("I'm a little little bird");
                break;
            case SWIMMING:
                System.out.println("Like a seaweed,seaweed,seaweed...");
                 break;
            default:
                System.out.println("Error....");
        }
    }
}

enum Action {
    RUN,SING,FLY,SWIMMING
}

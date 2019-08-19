package com.varcan;

import java.text.DecimalFormat;

/**
 * Date:2019-08-17
 * Author: var.can
 * Desc:
 */
public class App {
    public static void main(String[] args) {
        Rule rule = new Rule();
        rule.setLength(800.0);
        rule.setOverLength(800.0);
        rule.setRestLength(200.0);
        rule.setRestTime(2.0);

        Double firstReachTime = Test2SolutionGetFirstTimeAndSecondTime.getFirstReachTime(40.0, 60.0, rule);
        Double secondReachTime = Test2SolutionGetFirstTimeAndSecondTime.getSecondReachTime(40.0, 60.0, rule);
        DecimalFormat df = new DecimalFormat("0.00");
        if (firstReachTime <0){
            System.out.println("该时间不存在");
        }else System.out.println("第一次相遇时间"+df.format(firstReachTime));
        System.out.println("第二次相遇时间"+df.format(secondReachTime));
        System.out.println("Test2SolutionGetAllAnswerTime为此题第二种写法：满足该题意的所有超圈时间（包含静止状态）");
    }
}

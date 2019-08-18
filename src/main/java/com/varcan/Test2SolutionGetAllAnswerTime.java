package com.varcan;

import java.text.DecimalFormat;

/**
 * Date:2019-08-18
 * Author: var.can
 * Desc:
 */
public class Test2SolutionGetAllAnswerTime{
    /**
     * 建议看Test2SolutionGetFirstTimeAndSecondTime,更有逻辑性，算法角度更佳；
     * 此题共相遇3次；
     * 而这3次又有不同的停顿时间，所以值结果集有很多个值
     * @param args
     */
    public static void main(String[] args) {
        int second = 0;     //时间,秒
        double DIST_A = 0;  //A跑的距离
        double DIST_B = 0;  //B跑的距离

        int aRunTime = 0; //用以修复a跑动距离计算的小数精度丢失的问题
        double aRun = 0; //用以修复a跑动距离计算的小数精度丢失的问题

        int restA = 0;      //A休息计时
        int restB = 0;      //B休息计时

        boolean isRestA = false;  //A是否休息
        boolean isRestB = false;  //B是否休息

        double phases200_A = 0;   //统计A跑了200米
        double phases200_B = 0;   //统计B跑了200米
        double maxTime =800/((200/(200/60+2))-(200/(200/40+2)))*7/5*60;//按每200米的平均速度都超圈了时为最大时间
        DecimalFormat df = new DecimalFormat("#######0.00");
        while (second<maxTime) {
            //如果A休息
            if (isRestA) {
                restA++;
                //A休息够120秒
                if (restA == 120) {
                    restA = 0;
                    isRestA = false;
                }
            } else {
                //A正常跑
                aRunTime++;
                DIST_A = aRunTime * 4.0 / 6.0;
                phases200_A = DIST_A - aRun;
                //A跑够200米
                if (phases200_A >= 200) {
                    aRun+=200;
                    phases200_A = 0;
                    isRestA = true;
                }
            }
            //如果B休息
            if (isRestB) {
                restB++;
                //B休息够120秒
                if (restB == 120) {
                    restB = 0;
                    isRestB = false;
                }
            } else {
                //B正常跑
                DIST_B += 1;
                phases200_B += 1;
                //B跑够200米
                if (phases200_B >= 200) {
                    phases200_B = 0;
                    isRestB = true;
                }
            }
            second++;
            if (DIST_B == DIST_A + 800) {
                System.out.println("A跑的距离:" + DIST_A);
                System.out.println("B跑的距离:" + DIST_B);
                System.out.println("已经耗时:" + df.format(second/60.0) + "分");
            }
        }
    }
}


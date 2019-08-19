package com.varcan;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * Date:2019-08-17
 * Author: var.can
 * Desc:
 */
public class Test2SolutionGetFirstTimeAndSecondTime {
    /**
     * 数学逻辑计算第一次追击时间
     * @param aSpeed
     * @param bSpeed
     * @param rule
     * @return
     */
    public static double getFirstReachTime(double aSpeed,double bSpeed,Rule rule){
        double playgroundPerimeter = rule.getLength();
        double restTime = rule.getRestTime();
        double overLength = rule.getOverLength();
        double restLength = rule.getRestLength();
        //次：跑完200+休息时间这一范围计为一次
        double i = Math.floor(overLength/restLength);//起始次数，即题意超800的最少次数；
        double b = i;//a跑i次，b跑i-b次；逻辑如下所述
        double maxNum = overLength/((restLength/(restLength/bSpeed+restTime))-(restLength/(restLength/aSpeed+restTime)))
                * (overLength/aSpeed+restTime)/(overLength/aSpeed)/(restLength/bSpeed+restTime);
        maxNum=Math.ceil(maxNum);//按200米的平均速度计算b超圈时，b所需跑200米的最大次数；
        for (; i < maxNum; i++) {
            /**
             * 下面数字即题意；
             * 逻辑求得4 ； 超800米，即a多跑4个200；即4次；
             * 判断区间，第一次满足超圈时，b跑完i-4次，a正跑完i次，此时b的总时间（含休息时间）在
             * a跑完刚第ici（不含第i次的休息时间）和 a刚开始跑i+1次的时间内；
             */
            if (((restLength/bSpeed+restTime)*(i-1)+restLength/bSpeed)<(i-b)*(restLength/aSpeed+restTime)
                    &&(restLength/bSpeed+restTime)*i>(i-b)*(restLength/aSpeed+restTime)){
                return (i-1)*(restLength/bSpeed+restTime)+restLength/bSpeed;
            }
            i++;
        }
        return -1.0;
    }

    /**
     * 数学逻辑计算第二次追击时间
     * @param aSpeed
     * @param bSpeed
     * @param rule
     * @return
     */
    public static double getSecondReachTime(double aSpeed,double bSpeed,Rule rule){
        double playgroundPerimeter = rule.getLength();
        double restTime = rule.getRestTime();
        double overLength = rule.getOverLength();
        double restLength = rule.getRestLength();
        double num = playgroundPerimeter/restLength;
        double overLengthTotal = num * restTime * aSpeed + overLength;
        double restNum = 0.0;
        double runTime = overLengthTotal / (bSpeed - aSpeed);
        restNum = Double.parseDouble(Math.floor(runTime*bSpeed/restLength)+"");
        if (restNum==runTime*bSpeed/restLength){
            restNum = runTime*bSpeed/restLength-1;
        }
        return runTime+restNum*restTime;
    }


}

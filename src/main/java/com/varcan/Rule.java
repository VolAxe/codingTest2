package com.varcan;

/**
 * Date:2019-08-17
 * Author: var.can
 * Desc:
 */
public class Rule {
    private Double length;
    private Double restLength;
    /**
     * minute
     */
    private Double restTime;

    private Double overLength;


    public Double getOverLength() {
        return overLength;
    }

    public void setOverLength(Double overLength) {
        this.overLength = overLength;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getRestLength() {
        return restLength;
    }

    public void setRestLength(Double restLength) {
        this.restLength = restLength;
    }

    public Double getRestTime() {
        return restTime;
    }

    public void setRestTime(Double restTime) {
        this.restTime = restTime;
    }
}

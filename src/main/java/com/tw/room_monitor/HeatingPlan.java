package com.tw.room_monitor;

public class HeatingPlan {


    private final TempRange tempRange;

    HeatingPlan() {
        tempRange = null;
    }
    public HeatingPlan(TempRange tempRange) {
        this.tempRange = tempRange;
    }

    public TempRange getTempRange() {
        return tempRange;
    }
    public String getTempRangeAsString() {
        return tempRange.getLow() + " " + tempRange.getHigh();
    }

    public Boolean withInRange(TempRange tempRange) {
        System.out.println(tempRange.getLow());
        System.out.println(this.tempRange.getLow());
        System.out.println(tempRange.getHigh());
        return (tempRange.getLow() >= this.tempRange.getLow()) && (tempRange.getHigh() <= this.tempRange.getHigh());
    }

}

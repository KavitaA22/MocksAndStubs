package com.tw.room_monitor;

public class TempRange {
    float low;
    float high;
    TempRange(float low,float high) {
        this.low=low;
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public float getHigh() {
        return high;
    }
}

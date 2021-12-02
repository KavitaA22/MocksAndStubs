package com.tw.room_monitor;

//Consider a room monitoring system. It compares its daily temperature range with a range in a predefined heating plan.


public class ARoom {

TempRange tempRange;
    ARoom(){

    }

    public ARoom(TempRange tempRange) {
      this.tempRange =tempRange;
    }

    public TempRange getRoomTempRange() {
        return tempRange;
    }
    public String getTempRange() {
        return tempRange.getLow() + " " + tempRange.getHigh();
    }
}

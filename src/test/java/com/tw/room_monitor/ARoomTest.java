package com.tw.room_monitor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ARoomTest {
    private ARoom aRoom;
    private TempRange tempRange;
    @BeforeEach
    public void setUp() {
         tempRange = new TempRange(10,20);
        aRoom = new ARoom(tempRange);
    }

    @Test
    void shouldAbleToCreateRoom() {
        ARoom aRoom = new ARoom();
        assertNotSame(new ARoom(),aRoom);
    }
    @Test
    void shouldAbleToCreateRoomWithTempRange() {
        TempRange tempRangeNew = new TempRange(10,20);
        ARoom aRoomNew = new ARoom(tempRangeNew);

        assertNotSame(aRoom,aRoomNew);
    }

    @Test
    void shouldAbleToReturnRoomWithTempRange() {

        assertEquals("10.0 20.0",aRoom.getTempRange());

        TempRange tempRangeB = new TempRange(30,50);
        ARoom aRoomB = new ARoom(tempRangeB);
        assertEquals("30.0 50.0",aRoomB.getTempRange());
    }

}

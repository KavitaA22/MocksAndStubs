package com.tw.room_monitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class HeatingPlanTest {
    private HeatingPlan heatingPlan;
    private HeatingPlan testHeatingPlan;
    private TempRange tempRange;
    private TempRange testTempRange;
    @BeforeEach
    public void setUp() {
        tempRange = new TempRange(31,51);
        heatingPlan = new HeatingPlan(tempRange);
        testHeatingPlan = mock(HeatingPlan.class);
        testTempRange = mock(TempRange.class);

    }

    @Test
    void should_return_mock_heating_plan_null_when_temperature_not_passed() {
        when(testHeatingPlan.getTempRangeAsString()).thenReturn(null);
    }
    @Test
    void should_return_mock_heating_plan_values_when_temperature_is_passed() {
        when(testHeatingPlan.getTempRangeAsString()).thenReturn("31.0 51.0");
    }

    @Test
    void shouldAbleToCreateHeatingPlan() {

        HeatingPlan heatingPlan = new HeatingPlan();
        assertNotSame(heatingPlan,new HeatingPlan());
    }

    @Test
    void shouldAbleToCreateHeatingPlanWithTempRange() {
        assertEquals("31.0 51.0",heatingPlan.getTempRangeAsString());
    }

    @Test
    void TempRangeIsNullWhenNoHeatingPlanIsSet() {
        HeatingPlan heatingPlan = new HeatingPlan();
        assertNull(heatingPlan.getTempRange());
    }
    @Test
    void TempRangeIsNotNullWhenHeatingPlanIsSet() {
        assertNotNull(heatingPlan.getTempRangeAsString());
        assertNotNull(heatingPlan.getTempRange());
    }

    @Test
    void ShouldAbleToCheckRoomTemperatureRangeISEqualToHeatingPlanTemperature() {
        TempRange RoomTempRange = new TempRange(31,51);
        ARoom aRoom = new ARoom(RoomTempRange);
        assertEquals("31.0 51.0",aRoom.getTempRange());
        assertEquals(heatingPlan.getTempRangeAsString(),aRoom.getTempRange());
    }

    @Test
    void shouldAbleToCheckRoomTemperatureRangeInAccordanceWithHeatingPlan() {
        TempRange tempRange = new TempRange(21,51);
        TempRange RoomTempRange = new TempRange(31,51);
        HeatingPlan heatingPlan = new HeatingPlan(tempRange);
        ARoom aRoom = new ARoom(RoomTempRange);
        assertTrue(heatingPlan.withInRange(aRoom.getRoomTempRange()));

    }

    @Test
    void shouldAbleToCheckRoomTemperatureRangeNotInAccordanceWithHeatingPlan() {
        TempRange HPTempRange = new TempRange(91,51);
        TempRange RoomTempRange = new TempRange(31,51);
        HeatingPlan heatingPlan = new HeatingPlan(HPTempRange);
        ARoom aRoom = new ARoom(RoomTempRange);
        assertFalse(heatingPlan.withInRange(aRoom.getRoomTempRange()));

        System.out.println(aRoom.getRoomTempRange().getLow());
        System.out.println(aRoom.getTempRange());
        System.out.println(heatingPlan.getTempRangeAsString());
        System.out.println(heatingPlan.getTempRange().getLow());
        System.out.println(aRoom.getRoomTempRange().getLow());
        System.out.println(aRoom.getRoomTempRange().low);
        System.out.println(aRoom.getRoomTempRange().high);
        System.out.println(aRoom.getRoomTempRange().getHigh());
    }
}

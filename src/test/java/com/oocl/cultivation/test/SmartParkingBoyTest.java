package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    @Test
    void should_second_parkingLot_return_not_null_when_park_and_second_parkingLot_has_cars_given_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        firstParkingLot.park(new Car());
        firstParkingLot.park(new Car());
        //when
        smartParkingBoy.park(new Car());
        //then
        Assertions.assertEquals(1, secondParkingLot.getParkRooms().size());
    }
}

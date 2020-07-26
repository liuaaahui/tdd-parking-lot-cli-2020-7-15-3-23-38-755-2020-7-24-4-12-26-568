package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {
    @Test
    void should_park_anthor_parklot_when_park_given_11_cars() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        //when
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        Ticket ticket = parkingBoy.park(new Car());
        //then
        Assertions.assertNotNull(ticket);
    }
}

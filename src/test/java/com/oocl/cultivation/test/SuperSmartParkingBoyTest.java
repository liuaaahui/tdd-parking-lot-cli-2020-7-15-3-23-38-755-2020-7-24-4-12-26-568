package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoyTest {
    @Test
    void should_park_in_the_arger_available_position_rate_parkingLot_when_super_smart_parkingBoy_park_given_car() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot(16);
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        for (int count = 0; count < 6; count++) {
            firstParkingLot.park(new Car());
        }
        secondParkingLot.park(new Car());

        //when
        superSmartParkingBoy.park(new Car());

        //then
        Assertions.assertEquals(2, secondParkingLot.getParkRooms().size());
    }
}

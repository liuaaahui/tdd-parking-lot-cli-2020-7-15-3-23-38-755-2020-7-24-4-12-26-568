package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

public class ParkingLotFacts {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket carTicket = parkingLot.park(car);
        //then
        Assertions.assertNotNull(carTicket);
    }

    @Test
    void should_return_correspond_car_when_feach_given_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket carTicket = parkingLot.park(car);
        //when
        Car actualCar = parkingLot.feach(carTicket);
        //then
        Assertions.assertNotNull(actualCar);
        Assertions.assertEquals(car,actualCar);
    }
}

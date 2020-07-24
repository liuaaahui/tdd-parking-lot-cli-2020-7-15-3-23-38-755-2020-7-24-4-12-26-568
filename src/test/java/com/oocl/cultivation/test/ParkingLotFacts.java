package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

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
}

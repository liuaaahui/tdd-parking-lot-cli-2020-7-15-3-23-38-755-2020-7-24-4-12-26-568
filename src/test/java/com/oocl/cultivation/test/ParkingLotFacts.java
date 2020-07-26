package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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

    @Test
    void should_return_ticket_when_park_given_lot_cars() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket firstTicket = parkingLot.park(firstCar);
        Ticket secondTicket = parkingLot.park(secondCar);
        //then
        Assertions.assertNotNull(firstTicket);
        Assertions.assertNotNull(secondTicket);
    }

    @Test
    void should_return_correspond_cars_when_feach_given_lot_tickets() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket firstTicket = parkingLot.park(firstCar);
        Ticket secondTicket = parkingLot.park(secondCar);
        //when
        Car carWithFirstTicket = parkingLot.feach(firstTicket);
        Car carWithSecondTicket = parkingLot.feach(secondTicket);
        //then
        Assertions.assertNotNull(carWithFirstTicket);
        Assertions.assertNotNull(carWithSecondTicket);
        Assertions.assertEquals(carWithFirstTicket,firstCar);
        Assertions.assertEquals(carWithSecondTicket,secondCar);
    }

    @Test
    void should_return_null_when_feach_given_no_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        //when
        Car feachCar = parkingLot.feach(null);
        //then
        Assertions.assertNull(feachCar);
        Assertions.assertNotEquals(car,feachCar);
    }

    @Test
    void should_return_null_when_feach_given_used_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);
        //when
        parkingLot.feach(ticket);
        Car feachCar = parkingLot.feach(ticket);
        //then
        Assertions.assertNull(feachCar);
    }
}

package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() throws ParkingException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket carTicket = parkingLot.park(car);

        //then
        Assertions.assertNotNull(carTicket);
    }

    @Test
    void should_return_correspond_car_when_feach_given_ticket() throws ParkingException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket carTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.feach(carTicket);

        //then
        Assertions.assertNotNull(actualCar);
        Assertions.assertEquals(car, actualCar);
    }

    @Test
    void should_return_ticket_when_park_given_lot_cars() throws ParkingException {
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
    void should_return_correspond_cars_when_feach_given_lot_tickets() throws ParkingException {
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
        Assertions.assertEquals(carWithFirstTicket, firstCar);
        Assertions.assertEquals(carWithSecondTicket, secondCar);
    }

    @Test
    void should_have_error_message_when_feach_given_no_ticket() throws ParkingException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);

        //when
        Throwable exception = Assertions.assertThrows(ParkingException.class, () -> parkingLot.feach(null));

        //then
        Assertions.assertEquals("Please provide your parking ticket.\n",exception.getMessage());
    }

    @Test
    void should_return_null_when_feach_given_used_ticket() throws ParkingException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);

        //when
        parkingLot.feach(ticket);
        Throwable exception = Assertions.assertThrows(ParkingException.class, () -> parkingLot.feach(ticket));

        //then
        Assertions.assertEquals("Unrecognized parking ticket.\n",exception.getMessage());
    }

    @Test
    void should_throw_error_message_when_park_given_11_cars() throws ParkingException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        for (int count = 0; count < 10; count++) {
            parkingLot.park(new Car());
        }

        //when
        Throwable exception = Assertions.assertThrows(ParkingException.class, () -> parkingLot.park(new Car()));

        //then
        Assertions.assertEquals("Not enough position.\n",exception.getMessage());
    }
}

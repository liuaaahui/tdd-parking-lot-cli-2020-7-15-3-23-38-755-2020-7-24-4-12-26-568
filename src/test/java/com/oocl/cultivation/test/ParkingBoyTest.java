package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    void should_park_anthor_parklot_when_park_given_11_cars() throws ParkingException {
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

    @Test
    void should_return_ticket_when_park_given_car() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        //when
        Ticket ticket = parkingBoy.park(new Car());

        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_correspond_car_when_feach_given_ticket() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        //when
        Car feachCar = parkingBoy.feach(ticket);

        //then
        Assertions.assertEquals(car, feachCar);
    }

    @Test
    void should_return_correspond_cars_when_feach_given_lot_tickets() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Ticket firstTicket = parkingBoy.park(firstCar);
        Ticket secondTicket = parkingBoy.park(secondCar);

        //when
        Car carWithFirstTicket = parkingBoy.feach(firstTicket);
        Car carWithSecondTicket = parkingBoy.feach(secondTicket);

        //then
        Assertions.assertNotNull(carWithFirstTicket);
        Assertions.assertNotNull(carWithSecondTicket);
        Assertions.assertEquals(carWithFirstTicket, firstCar);
        Assertions.assertEquals(carWithSecondTicket, secondCar);
    }

    @Test
    void should_return_null_when_feach_given_no_ticket() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        parkingBoy.park(car);

        //when
        Car feachCar = parkingBoy.feach(null);

        //then
        Assertions.assertNull(feachCar);
        Assertions.assertNotEquals(car, feachCar);
    }

    @Test
    void should_throw_error_message_when_feach_given_used_ticket() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        //when
        parkingBoy.feach(ticket);
        Throwable exception = Assertions.assertThrows(ParkingException.class, () -> parkingBoy.feach(ticket));

        //then
        Assertions.assertEquals("Unrecognized parking ticket.\n",exception.getMessage());
    }

    @Test
    void should_throw_error_message_when_feach_given_no_ticket() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        parkingBoy.park(car);

        //when
        parkingBoy.feach(null);

        //then
        Assertions.assertTrue(systemOut().endsWith("Please provide your parking ticket.\n"));
    }

    @Test
    void should_throw_error_message_when_hava_one_parklot_given_11_cars() throws ParkingException {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        for (int count = 0; count < 10; count++) {
            parkingBoy.park(new Car());
        }

        //when
        Throwable exception = Assertions.assertThrows(ParkingException.class, () -> parkingBoy.park(new Car()));

        //then
        Assertions.assertEquals("Not enough position.\n",exception.getMessage());
    }
}

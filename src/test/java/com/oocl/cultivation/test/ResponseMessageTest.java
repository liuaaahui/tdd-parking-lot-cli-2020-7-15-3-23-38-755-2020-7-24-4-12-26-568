package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ResponseMessageTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    void should_have_error_message_when_feach_given_no_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        //when
        Car feachCar = parkingLot.feach(null);
        //then
        Assertions.assertTrue(systemOut().endsWith("Unrecognized parking ticket.\n"));
    }

    @Test
    void should_have_error_message_when_feach_given_used_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);
        //when
        parkingLot.feach(ticket);
        parkingLot.feach(ticket);
        //then
        Assertions.assertTrue(systemOut().endsWith("Unrecognized parking ticket.\n"));
    }
}

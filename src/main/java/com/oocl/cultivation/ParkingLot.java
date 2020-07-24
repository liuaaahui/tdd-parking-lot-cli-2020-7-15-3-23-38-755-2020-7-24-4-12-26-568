package com.oocl.cultivation;


public class ParkingLot {
    public Ticket park(Car car) {
        Ticket ticket = new Ticket(car);
        return ticket;
    }

    public Car feach(Ticket carTicket) {
        return carTicket.getCar();
    }
}

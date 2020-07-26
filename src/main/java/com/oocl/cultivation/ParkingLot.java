package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkRoom;

    public ParkingLot() {
        this.parkRoom = new HashMap<>();
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket(car);
        return ticket;
    }

    public Car feach(Ticket carTicket) {
        if (carTicket == null) return null;
        return this.parkRoom.remove(carTicket);
    }
}

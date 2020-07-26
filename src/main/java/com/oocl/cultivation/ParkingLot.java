package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<Ticket, Car> parkRooms;
    private final int PARKROOM_CAPACITY = 10;

    public ParkingLot() {
        this.parkRooms = new HashMap<>();
    }

    public Ticket park(Car car) {
        if (this.parkRooms.size() == this.PARKROOM_CAPACITY){
            return null;
        }
        Ticket ticket = new Ticket();
        this.parkRooms.put(ticket, car);
        return ticket;
    }

    public Car feach(Ticket carTicket) {
        return this.parkRooms.remove(carTicket);
    }
}

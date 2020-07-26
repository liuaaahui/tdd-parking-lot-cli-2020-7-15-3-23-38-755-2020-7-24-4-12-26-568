package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<Ticket, Car> parkRooms;
    private final int PARKROOM_CAPACITY = 10;

    public ParkingLot() {
        this.parkRooms = new HashMap<>();
    }

    public Map<Ticket, Car> getParkRooms() {
        return parkRooms;
    }

    public Ticket park(Car car) {
        if (this.parkRooms.size() >= this.PARKROOM_CAPACITY){
            System.out.print("Not enough position.\n");
            return null;
        }
        Ticket ticket = new Ticket();
        this.parkRooms.put(ticket, car);
        return ticket;
    }

    public Car feach(Ticket carTicket) {
        if (carTicket == null){
            System.out.print("Please provide your parking ticket.\n");
            return null;
        }
        if (this.parkRooms.containsKey(carTicket)) {
            System.out.print("Unrecognized parking ticket.\n");
            return null;
        }
        return this.parkRooms.remove(carTicket);
    }
}

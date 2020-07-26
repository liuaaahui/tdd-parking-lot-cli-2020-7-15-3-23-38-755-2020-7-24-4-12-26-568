package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<Ticket, Car> parkRooms;
    private final int capacity;

    public ParkingLot() {
        this.capacity = 10;
        this.parkRooms = new HashMap<>();
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkRooms = new HashMap<>();
    }

    public Map<Ticket, Car> getParkRooms() {
        return parkRooms;
    }

    public int getCapacity() {
        return capacity;
    }

    public Ticket park(Car car) {
        if (this.parkRooms.size() >= this.capacity) {
            System.out.print("Not enough position.\n");
            return null;
        }
        Ticket ticket = new Ticket();
        this.parkRooms.put(ticket, car);
        return ticket;
    }

    public Car feach(Ticket carTicket) {
        if (carTicket == null) {
            System.out.print("Please provide your parking ticket.\n");
            return null;
        }
        if (!this.parkRooms.containsKey(carTicket)) {
            System.out.print("Unrecognized parking ticket.\n");
            return null;
        }
        return this.parkRooms.remove(carTicket);
    }
}

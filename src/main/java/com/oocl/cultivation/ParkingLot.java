package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.\n";
    private static final String NOT_ENOUGH_POSITION = "Not enough position.\n";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.\n";
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

    public Ticket park(Car car) throws ParkingException {
        if (!isCapacityFull()){
            Ticket ticket = new Ticket();
            this.parkRooms.put(ticket, car);
            return ticket;
        }
        return null;
    }
    public boolean isCapacityFull() throws ParkingException{
        if (this.parkRooms.size() >= this.capacity) {
            throw new ParkingException(NOT_ENOUGH_POSITION);
        }
        return false;
    }
    public Car feach(Ticket carTicket) throws ParkingException {
        if (carTicket == null) {
            throw new ParkingException(PLEASE_PROVIDE_YOUR_PARKING_TICKET);
        }
        if (!this.parkRooms.containsKey(carTicket)) {
            throw new ParkingException(UNRECOGNIZED_PARKING_TICKET);
        }
        return this.parkRooms.remove(carTicket);
    }
}

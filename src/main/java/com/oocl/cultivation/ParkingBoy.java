package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.\n";
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public Ticket park(Car car) throws ParkingException {
        int parkingLotNumber = 0;
        ParkingLot parkingLot = this.parkingLotList.get(parkingLotNumber);
        if (parkingLot.isFull() && this.parkingLotList.size() > 1) {
            parkingLotNumber++;
            parkingLot = this.parkingLotList.get(parkingLotNumber);
        }
        return parkingLot.park(car);
    }

    public Car fetch(Ticket carTicket) throws ParkingException {
        if (carTicket == null) {
            throw new ParkingException(PLEASE_PROVIDE_YOUR_PARKING_TICKET);
        }
        Car car = null;
        for (ParkingLot parkingLot : this.parkingLotList) {
            car = parkingLot.fetch(carTicket);
            if (car != null) return car;
        }
        return car;
    }
}

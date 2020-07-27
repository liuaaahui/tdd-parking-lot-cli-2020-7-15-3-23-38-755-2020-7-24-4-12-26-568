package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
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
        if (parkingLot.getParkRooms().size() >= 10 && this.parkingLotList.size() > 1) {
            parkingLotNumber++;
            parkingLot = this.parkingLotList.get(parkingLotNumber);
        }
        return parkingLot.park(car);
    }

    public Car feach(Ticket carTicket) {
        if (carTicket == null) {
            System.out.print("Please provide your parking ticket.\n");
            return null;
        }
        Car car = null;
        for (ParkingLot parkingLot : this.parkingLotList) {
            car = parkingLot.feach(carTicket);
            if (car != null) return car;
        }
        return car;
    }
}

package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        int parkingLotNumber = 0;
        ParkingLot parkingLot = this.parkingLotList.get(parkingLotNumber);
        if (parkingLot.getParkRooms().size() >= 10) {
            parkingLotNumber++;
            parkingLot = this.parkingLotList.get(parkingLotNumber);
        }
        return parkingLot.park(car);
    }
}

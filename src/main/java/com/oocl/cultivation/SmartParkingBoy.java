package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket park(Car car) throws ParkingException {
        ParkingLot parkingLotFlag = this.getParkingLotList().get(0);
        for (ParkingLot parkingLot : this.getParkingLotList()) {
            int parkingLotSize = parkingLot.getCapacity() - parkingLot.getParkRooms().size();
            int parkingLotFlagSize = parkingLotFlag.getCapacity() - parkingLotFlag.getParkRooms().size();
            if (parkingLotSize > parkingLotFlagSize) {
                parkingLotFlag = parkingLot;
            }
        }
        return parkingLotFlag.park(car);
    }
}

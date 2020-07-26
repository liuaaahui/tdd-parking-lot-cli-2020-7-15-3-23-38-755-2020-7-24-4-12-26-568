package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLotFlag = this.getParkingLotList().get(0);
        for (ParkingLot parkingLot : this.getParkingLotList()) {
            if (parkingLot.getParkRooms().size() * parkingLotFlag.getCapacity() < parkingLotFlag.getParkRooms().size() * parkingLot.getCapacity()) {
                parkingLotFlag = parkingLot;
            }
        }
        return parkingLotFlag.park(car);
    }
}

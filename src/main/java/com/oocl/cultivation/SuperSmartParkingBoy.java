package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket park(Car car) throws ParkingException {
        ParkingLot parkingLotFlag = this.getParkingLotList().get(0);
        for (ParkingLot parkingLot : this.getParkingLotList()) {
            double firstPositionRate = (double) parkingLot.getParkRooms().size() / parkingLot.getCapacity();
            double secondPositionRate = (double) parkingLotFlag.getParkRooms().size() / parkingLotFlag.getCapacity();
            if (firstPositionRate < secondPositionRate) {
                parkingLotFlag = parkingLot;
            }
        }
        return parkingLotFlag.park(car);
    }
}

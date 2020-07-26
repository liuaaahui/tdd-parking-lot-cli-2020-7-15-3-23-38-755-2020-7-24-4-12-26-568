package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLotFlag = this.getParkingLotList().get(0);
        for(ParkingLot parkingLot: this.getParkingLotList()){
            if(parkingLot.getParkRooms().size()<parkingLotFlag.getParkRooms().size()){
                parkingLotFlag = parkingLot;
            }
        }
        return parkingLotFlag.park(car);
    }
}

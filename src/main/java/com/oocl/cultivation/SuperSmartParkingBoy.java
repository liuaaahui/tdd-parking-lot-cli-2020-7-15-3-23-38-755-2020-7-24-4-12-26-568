package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket park(Car car) {
        return super.park(car);
    }
}

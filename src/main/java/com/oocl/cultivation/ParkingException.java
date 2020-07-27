package com.oocl.cultivation;

public class ParkingException extends Exception {
    private String message;

    public ParkingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

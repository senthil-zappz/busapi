package com.javaproject.busapi.Exceptions;

public class busRouteNotFoundException extends RuntimeException {
    public busRouteNotFoundException(String busService) {
        super("Could not find bus service: " + busService);

    }

}

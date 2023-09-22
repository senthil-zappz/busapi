package com.javaproject.busapi.Exceptions;

public class busStopNotFoundException extends RuntimeException {
  public busStopNotFoundException(String busStopCode) { 
    super("Could not find busStop " + busStopCode);
    
  }
 
}

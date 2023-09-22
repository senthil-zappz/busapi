package com.javaproject.busapi.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.javaproject.busapi.Entity.busStops;

public interface busStopService { 

  busStops getbusStop(String busStopCode);

  ArrayList<busStops> getAllbusStops(); 
 
}

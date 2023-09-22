package com.javaproject.busapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import com.javaproject.busapi.Entity.busStops;
import com.javaproject.busapi.Exceptions.busStopNotFoundException;
import com.javaproject.busapi.Repository.busStopRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class busStopServiceImpl implements busStopService {
   private static final Logger logger = LoggerFactory.getLogger(busStopServiceImpl.class);
    
   private busStopRepository busStopRepository;

   @Autowired
   public busStopServiceImpl(busStopRepository busStopRepository) {
      this.busStopRepository = busStopRepository; 
   }

   @Override 
   public busStops getbusStop(String busStopCode){ 
      Optional<busStops> optionalbusStop = busStopRepository.findByBusstopcode(busStopCode);
      if(optionalbusStop.isPresent()){
         return optionalbusStop.get(); 
      }
      logger.info("encountered busStopNotFoundException at getBusStop");
      throw new busStopNotFoundException(busStopCode); 
   } 
   
  @Override
  public ArrayList<busStops> getAllbusStops() {
      List<busStops> allBusStops = busStopRepository.findAll();
      return (ArrayList<busStops>) allBusStops;
  }
 
 
}

package com.javaproject.busapi.Files;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class busServiceImpl implements busServicesService {
    private static final Logger logger = LoggerFactory.getLogger(busServiceImpl.class);
   private busServicesRepository busServicesRepository;

   @Autowired
   public busServiceImpl(busServicesRepository busServicesRepository) {
      this.busServicesRepository = busServicesRepository; 
   }

//    @Override 
//    public busServices getbusServices(String serviceno){ 
//       List<busServices> optionalbusServices = busServicesRepository.findByServiceno(serviceno);
//          return optionalbusServices; }
 
   @Override
public List<busServices> getbusServices(String Serviceno) {
    List<busServices> foundbusServices = busServicesRepository.findByServiceno(Serviceno);
    // Check if any bus services were found
    // Check if any bus services were found
    return foundbusServices;}
//     if (!foundbusServices.isEmpty()) {
//       return foundbusServices.get(0); // Return the first element
//     }

//     logger.info("encountered busStopNotFoundException at getBusStop");
//     throw new busServicesNotFoundException(Serviceno); 
// }

@Override
  public ArrayList<busServices> getAllBusServices() {
    List<busServices> allBusServices = busServicesRepository.findAll();
    return (ArrayList<busServices>) allBusServices;
  }
//   @Override
//   public ArrayList<busServices> getAllbusservices(serviceno) {
//     List<busServices> allBusServices = busServicesRepository.findAll();
//     return (ArrayList<busServices>) allBusServices;
//   }

}


  



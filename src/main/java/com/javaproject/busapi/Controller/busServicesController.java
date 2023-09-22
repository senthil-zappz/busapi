package com.javaproject.busapi.Files;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/busservices")

public class busServicesController {
    private static final Logger logger = LoggerFactory.getLogger(busServicesController.class);
    private busServicesService busServicesService;

@Autowired
    public busServicesController( busServicesService busServicesService) {
        this.busServicesService = busServicesService;}

// @GetMapping("")
//     public ResponseEntity<ArrayList<busServices>> getAllbusService() { 
//         ArrayList<busServices> allbusService = busServicesService.getAllbusService(); 
//         return new ResponseEntity<>(allbusService, HttpStatus.OK);
//     }

//     @GetMapping("/{serviceno}")
// public ResponseEntity<List<busServices>> getbusServices(@PathVariable("serviceno") String serviceno) {
//     List<busServices> servicesList = busServicesService.getbusServices(serviceno);
//     return new ResponseEntity<>(servicesList, HttpStatus.CREATED);
   
// }
    @GetMapping("")
    public ResponseEntity<ArrayList<busServices>> getAllBusServices() { 
        logger.info("getAllBusServices");
        ArrayList<busServices> allBusServices = busServicesService.getAllBusServices(); 
        return new ResponseEntity<>(allBusServices, HttpStatus.OK);
    }

@GetMapping("/{busservices}")
    public ResponseEntity<List<busServices>> getbusService(@PathVariable(name ="busservices", required= true) String serviceno) {
        logger.info("getBusService" + serviceno);
            List <busServices> foundbusServices = busServicesService.getbusServices(serviceno);
            if (foundbusServices.isEmpty()) {
                logger.error("Service number not found : " + serviceno);
                throw new busServicesNotFoundException(serviceno);
            }
    
            else {
                return new ResponseEntity<>( foundbusServices, HttpStatus.OK);
            }

    }
}
        // try
    //         return new ResponseEntity<>(foundbusServices, HttpStatus.OK);
    //     } catch (busServicesNotFoundException e) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    //     }
    // }


// private int getCustomerIndex(String id) {
//     for( Customer customer: customers) {
//         if(customer.getId().equals(id)) {
//             return customers.indexOf(customer);
//         }
//     }

    // Not found
    // return -1;



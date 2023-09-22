package com.javaproject.busapi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import com.javaproject.busapi.Entity.busStops;
import com.javaproject.busapi.Exceptions.busStopNotFoundException;
import com.javaproject.busapi.Service.busStopService; 
 
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/busstops")
public class busstopController {
    
    private static final Logger logger = LoggerFactory.getLogger(busstopController.class);

    private busStopService busStopService;

    @Autowired
    public busstopController(@Qualifier("busStopServiceImpl") busStopService busStopService) {
        this.busStopService = busStopService;
    }
     
    @GetMapping("")
    public ResponseEntity<ArrayList<busStops>> getAllBusStop() { 
        logger.info("getAllBusStop");

        ArrayList<busStops> allBusStops = busStopService.getAllbusStops();
        return new ResponseEntity<>(allBusStops, HttpStatus.OK);
    }

    @GetMapping("{busstopcode}")
    public ResponseEntity<busStops> getBusStop(@PathVariable String busstopcode) {
        logger.info("getBusStop" + busstopcode);
        try {
            busStops foundBusStops = busStopService.getbusStop(busstopcode);
            return new ResponseEntity<>(foundBusStops, HttpStatus.OK);
        } catch (busStopNotFoundException e) {
            logger.info("encountered busStopNotFoundException at getBusStop");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

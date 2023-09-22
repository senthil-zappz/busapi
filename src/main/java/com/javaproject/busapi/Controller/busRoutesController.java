package com.javaproject.busapi.Controller;

import com.javaproject.busapi.Entity.busArrivals;
import com.javaproject.busapi.Entity.busRoutes;
import com.javaproject.busapi.Exceptions.busRouteNotFoundException;
import com.javaproject.busapi.Service.busRoutesService;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Map;

@RestController
// @RequestMapping("/busroutes")
@AllArgsConstructor
public class busRoutesController {
    private static final Logger logger = LoggerFactory.getLogger(busRoutesController.class);

    private busRoutesService busRoutesService;

    @GetMapping("/")
    public ResponseEntity<String> showHelp() {
        logger.error("Empty call to end point");
        return new ResponseEntity<>(
                "Hi, welcome to busapi \r\n You can use the follwing endpoints to access busapi \r\n /busroutes/{serviceno}\r\n /busarrival/{busstopcode} \r\n /busarrival/{busstopcode}/{busservice}\r\n /busstops \r\n /busstops/{busstopcode}\t\n /busservices \r\n /busservices/{serviceno}",
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/busroutes")
    public ResponseEntity<String> emtpyRequest() {
        logger.error("Service number parameter empty ");
        return new ResponseEntity<>("Service number is required", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/busroutes/{serviceno}")

    public ResponseEntity<List<busRoutes>> getBusRoutes(@PathVariable String serviceno) {
        logger.info("New call for service number: " + serviceno);

        List<busRoutes> busRoutes = busRoutesService.getBusRoutes(serviceno);
        if (busRoutes.isEmpty()) {
            logger.error("Service number not found : " + serviceno);
            throw new busRouteNotFoundException(serviceno);
        }

        else {
            return new ResponseEntity<>(busRoutes, HttpStatus.OK);
        }

    }

    // https://www.phpix.com/myNextBus/api.php?BusStopCode=01019&ServiceNo=12
    // https://www.phpix.com/myNextBus/api.php?BusStopCode=01019&ServiceNo=

    @GetMapping("/busarrival")
    public ResponseEntity<String> busArrivalWithoutParams() {
        logger.error("error calling busarrival without params");
        return new ResponseEntity<>("Missing parameter. /bussarrival/busstop or /busarrival/busstop/busservice",
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/busarrival/{busstop}")
    public ResponseEntity<String> busArrival(@PathVariable String busstop) {

        logger.info("new call for busarrival (param busstop)");

        // check busstop available if not throw error.
        // check_busstop(busstop);
        String url = "https://www.phpix.com/myNextBus/api.php?BusStopCode=" + busstop;
        RestTemplate restTemplate = new RestTemplate();

        String resp = restTemplate.getForObject(url, String.class);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/busarrival/{busstop}/{busservice}")
    public ResponseEntity<String> busArrival(@PathVariable String busstop, @PathVariable String busservice) {

        logger.info("new call for busarrival (busstop : " + busstop + " bus service : " + busservice + " )");

        // check busstop available if not throw error.
        // check_busstop(busstop);

        // check busservice available if not throw error
        // check busservice(busservice);

        String url = "https://www.phpix.com/myNextBus/api.php?BusStopCode=" + busstop + "&ServiceNo=" + busservice;
        RestTemplate restTemplate = new RestTemplate();

        String resp = restTemplate.getForObject(url, String.class);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}

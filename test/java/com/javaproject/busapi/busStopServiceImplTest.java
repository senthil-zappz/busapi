package com.javaproject.busapi;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.*; 
import com.javaproject.busapi.Repository.busStopRepository;
import com.javaproject.busapi.Service.busStopServiceImpl;
import com.javaproject.busapi.Entity.busStops;
import com.javaproject.busapi.Exceptions.busStopNotFoundException;

@SpringBootTest
public class busStopServiceImplTest {
    
    @Mock
    private busStopRepository busStopRepository;

    @InjectMocks
    busStopServiceImpl busStopService;

    @Test 
    public void getBusStopTest(){

        // 1. SETUP
        // Create a new customer
        busStops busStop = busStops.builder().busstopcode("01012").roadname("Victoria St").description("Hotel Grand Pacific")
            .latitude("1.29684825487647").longitude("103.85253591654006").build();
  
        when(busStopRepository.findByBusstopcode("01012")).thenReturn(Optional.of(busStop));

        // 2. EXECUTE
        busStops retrievedBusStop = busStopService.getbusStop("01012");

        // 3. ASSERT
        assertEquals(busStop, retrievedBusStop);
    }

    @Test
    void getbusStopNotFoundTest(){
        String busstopcode = "A";
        when(busStopRepository.findByBusstopcode(busstopcode)).thenReturn(Optional.empty());

        //Assert
        assertThrows(busStopNotFoundException.class,()->busStopService.
        getbusStop(busstopcode));
    }

}

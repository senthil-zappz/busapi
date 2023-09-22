package com.javaproject.busapi.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.busapi.Entity.busRoutes;
import com.javaproject.busapi.Repository.busRoutesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class busRoutesServiceImpl implements busRoutesService {

    private busRoutesRepository busRoutesRepository;

    @Override
    public ArrayList<busRoutes> getBusRoutes(String busService) {
        List<busRoutes> resultBusRoutes = busRoutesRepository.findByServiceno(busService);
        return (ArrayList<busRoutes>) resultBusRoutes;
        // return (ArrayList<busRoutes>)
        // busRoutesRepository.findByServiceno(busService);
    }

}

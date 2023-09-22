package com.javaproject.busapi.Service;

import com.javaproject.busapi.Entity.busRoutes;
import java.util.ArrayList;
import java.util.List;

public interface busRoutesService {

    // get bus routes
    List<busRoutes> getBusRoutes(String busService);

}

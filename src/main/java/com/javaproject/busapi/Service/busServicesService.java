package com.javaproject.busapi.Files;

import java.util.ArrayList;
import java.util.List;


public interface busServicesService {
  

  List <busServices> getbusServices(String serviceno);
  ArrayList<busServices> getAllBusServices();
  // List<busServices> getAllbusservices(String serviceno);

}

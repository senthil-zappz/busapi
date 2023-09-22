
package com.javaproject.busapi.Files;

public class busServicesNotFoundException extends RuntimeException {
  public busServicesNotFoundException(String serviceno) { 
    super("Could not find busStop " + serviceno);
    
  }
 
}


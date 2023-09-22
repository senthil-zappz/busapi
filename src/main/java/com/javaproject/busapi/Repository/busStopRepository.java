package com.javaproject.busapi.Repository;

import java.util.Optional;

import com.javaproject.busapi.Entity.busStops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface busStopRepository extends JpaRepository<busStops, Long>{
    Optional<busStops> findByBusstopcode(String busstopcode);  
}

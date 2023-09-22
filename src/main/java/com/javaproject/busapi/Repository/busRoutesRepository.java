package com.javaproject.busapi.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.busapi.Entity.busRoutes;

public interface busRoutesRepository extends JpaRepository<busRoutes, String> {
    List<busRoutes> findByServiceno(String serviceno);

}

// ArrayList<busRoutes> findByServiceno(String serviceno);
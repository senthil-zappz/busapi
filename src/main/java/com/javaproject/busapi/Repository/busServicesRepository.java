package com.javaproject.busapi.Files;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface busServicesRepository extends JpaRepository<busServices, String> {

    List<busServices> findByServiceno(String Serviceno);
}
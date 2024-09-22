package com.example.driver_app_kafka.controller;


import com.example.driver_app_kafka.service.LocationService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @PutMapping
    public ResponseEntity updateLocation(){

        locationService.updateLocation();
        return new ResponseEntity<>(
                Map.of("message", "Location Updated"),
                HttpStatus.OK);

    }
}

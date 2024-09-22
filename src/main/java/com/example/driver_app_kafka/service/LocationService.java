package com.example.driver_app_kafka.service;


import com.example.driver_app_kafka.constant.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.xml.stream.Location;

@Service
public class LocationService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean updateLocation(String location){
        kafkaTemplate.send(AppConstants.CAP_LOCATION, location);
        return true;
    }


    public void updateLocation() {
        int range = 50;

        double latValue, longValue;
        while(range >0){
            latValue = Math.random();
            longValue = Math.random();
            updateLocation(latValue + "," + longValue);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(latValue + " " + longValue);

            // publish these values to kafka.
            range--;
        }

    }
}

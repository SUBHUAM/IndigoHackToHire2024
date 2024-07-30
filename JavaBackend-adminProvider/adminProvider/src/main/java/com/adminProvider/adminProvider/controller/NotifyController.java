package com.adminProvider.adminProvider.controller;


import com.adminProvider.adminProvider.dto.FlightDetailsDto;
import com.adminProvider.adminProvider.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifyController {

   private final NotificationService notificationService;


    @Autowired
    public NotifyController(NotificationService notificationService){
        this.notificationService=notificationService;
    }

    @PostMapping("/sendNotification")
    public ResponseEntity<?> sendNotify(@RequestBody FlightDetailsDto flightDetailsDto){
        String status=notificationService.sendNotification(flightDetailsDto);
        if(status==null){
            return new ResponseEntity<>("Status Not updated", HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}

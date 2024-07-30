package com.userConsumer.userConsumer.controller;


import com.userConsumer.userConsumer.dto.FlightDetailsDto;
import com.userConsumer.userConsumer.services.NotificationServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private final NotificationServiceUser notificationServiceUser;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationController(NotificationServiceUser notificationServiceUser){
        this.notificationServiceUser=notificationServiceUser;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/flight-updates")
    public FlightDetailsDto sendPushNotification(@Payload FlightDetailsDto flightDetailsDto){
        return flightDetailsDto;

    }
}

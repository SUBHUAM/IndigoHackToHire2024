package com.userConsumer.userConsumer.services;

import com.userConsumer.userConsumer.constants.KafkaConstants;
import com.userConsumer.userConsumer.controller.NotificationController;
import com.userConsumer.userConsumer.dto.FlightDetailsDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;



@Service
public class NotificationServiceImpl implements NotificationServiceUser {

    @Autowired
    SimpMessagingTemplate template;
    @KafkaListener(topics = "notification-service", groupId = KafkaConstants.group_id)
    public void notificationService(ConsumerRecord<String,FlightDetailsDto>  flightDetailsDto){

        FlightDetailsDto flightDetailsDtonew=flightDetailsDto.value();
        
        System.out.println(flightDetailsDtonew);

        template.convertAndSend("/topic/flight-updates",flightDetailsDtonew);
    }

}

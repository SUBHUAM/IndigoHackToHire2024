package com.adminProvider.adminProvider.services;


import com.adminProvider.adminProvider.dto.FlightDetailsDto;
import com.adminProvider.adminProvider.entity.FlightDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private KafkaTemplate<String,FlightDetailsDto> kafkaTemplate;
    @Override
    public String sendNotification(FlightDetailsDto flightDetailsDto) {

        try{
            kafkaTemplate.send("notification-service",flightDetailsDto);
            return "Status updated";
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}

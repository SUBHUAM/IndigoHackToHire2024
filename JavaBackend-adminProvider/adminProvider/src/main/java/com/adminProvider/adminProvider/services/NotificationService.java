package com.adminProvider.adminProvider.services;

import com.adminProvider.adminProvider.dto.FlightDetailsDto;
import com.adminProvider.adminProvider.entity.FlightDetails;
import org.springframework.stereotype.Component;


@Component
public interface NotificationService {
    public String sendNotification(FlightDetailsDto flightDetailsDto);

}

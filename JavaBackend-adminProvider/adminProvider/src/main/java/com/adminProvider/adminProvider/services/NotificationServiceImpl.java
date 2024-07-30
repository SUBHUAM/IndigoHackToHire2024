package com.adminProvider.adminProvider.services;


import com.adminProvider.adminProvider.dto.FlightDetailsDto;
import com.adminProvider.adminProvider.entity.FlightDetails;
import com.adminProvider.adminProvider.respository.FlightRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private KafkaTemplate<String,FlightDetailsDto> kafkaTemplate;

    @Autowired
    private FlightRespository flightRespository;

    @Override
    public String sendNotification(FlightDetailsDto flightDetailsDto) {

        try{

            FlightDetails flightDetails=flightRespository.findByFlightNo(flightDetailsDto.getFlightNo());

            if(flightDetails==null){
                return null;
            }

            flightDetails.setFlightNo(flightDetails.getFlightNo());
            flightDetails.setOrigin(flightDetailsDto.getOrigin());
            flightDetails.setDestination(flightDetailsDto.getDestination());
            flightDetails.setGateNo(flightDetailsDto.getGateNo());
            flightDetails.setDepartureDate(flightDetailsDto.getDepartureDate());
            flightDetails.setCancellation(flightDetailsDto.getCancellation());

            flightRespository.save(flightDetails);

            kafkaTemplate.send("notification-service",flightDetailsDto);

            return "Status updated";
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}

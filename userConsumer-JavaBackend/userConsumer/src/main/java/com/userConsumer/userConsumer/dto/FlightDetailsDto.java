package com.userConsumer.userConsumer.dto;

import lombok.*;

import java.time.Instant;
import java.time.LocalTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetailsDto {
    private String flightNo;
    private String origin;
    private String destination;
    private Instant departureDate;
    private LocalTime localTime;
    private String gateNo;
    private String cancellation;
}
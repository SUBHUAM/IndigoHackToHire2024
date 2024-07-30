package com.adminProvider.adminProvider.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    private String gateNo;
    private String cancellation;
}

package com.adminProvider.adminProvider.respository;

import com.adminProvider.adminProvider.entity.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRespository extends JpaRepository<FlightDetails,Long> {
    FlightDetails findByFlightNo(String flightNo);
}

package com.adminProvider.adminProvider.controller;

import com.adminProvider.adminProvider.dto.BookingIdList;
import com.adminProvider.adminProvider.entity.Bookings;
import com.adminProvider.adminProvider.entity.FlightDetails;
import com.adminProvider.adminProvider.services.FlightService;
import com.adminProvider.adminProvider.services.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightDetailsController {

    FlightService flightService;

    public FlightDetailsController(FlightService flightService){
        this.flightService=flightService;
    }

    @GetMapping("/flightDetails/{flightNo}")
    public ResponseEntity<FlightDetails> getFlightDetails(@PathVariable String flightNo){
         FlightDetails flightDetails=flightService.getFlightDetails(flightNo);

         if(flightDetails==null){
             return new ResponseEntity<>(flightDetails, HttpStatus.INTERNAL_SERVER_ERROR);
         }
         else if(flightDetails.getFlightNo()==null){
             return new ResponseEntity<>(flightDetails, HttpStatus.NOT_FOUND);
         }

        return new ResponseEntity<>(flightDetails, HttpStatus.OK);
    }
    @GetMapping("/bookingDetails/{bookingId}")
    public ResponseEntity<Bookings> getBookingDetails(@PathVariable String bookingId){
        Bookings bookingDetails=flightService.getUserBooking(bookingId);

        if(bookingDetails==null){
            return new ResponseEntity<>(bookingDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if(bookingDetails.getFlightNo()==null){
            return new ResponseEntity<>(bookingDetails, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
    }
    @GetMapping("/getAllBookingId")
    public ResponseEntity<BookingIdList> getAllBookingId(){
        BookingIdList bookingIdList=flightService.getAllBookingById();

        return new ResponseEntity<>(bookingIdList, HttpStatus.OK);
    }
}

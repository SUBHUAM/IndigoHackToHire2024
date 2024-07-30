package com.adminProvider.adminProvider.services;

import com.adminProvider.adminProvider.dto.BookingIdList;
import com.adminProvider.adminProvider.entity.Bookings;
import com.adminProvider.adminProvider.entity.FlightDetails;
import org.springframework.stereotype.Component;


@Component
public interface FlightService {

    public FlightDetails getFlightDetails(String flightNo);

    public Bookings getUserBooking(String bookingId);

    public BookingIdList getAllBookingById();
}

package com.adminProvider.adminProvider.services;

import com.adminProvider.adminProvider.dto.BookingIdList;
import com.adminProvider.adminProvider.entity.Bookings;
import com.adminProvider.adminProvider.entity.FlightDetails;
import com.adminProvider.adminProvider.respository.BookingRepository;
import com.adminProvider.adminProvider.respository.FlightRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    BookingRepository bookingRepository;

    FlightRespository flightRespository;

    @Autowired
    public FlightServiceImpl(BookingRepository bookingRepository,FlightRespository flightRespository){
        this.bookingRepository=bookingRepository;
        this.flightRespository=flightRespository;
    }

    @Override
    public FlightDetails getFlightDetails(String flightNo) {
        try{
            FlightDetails flightDetails=flightRespository.findByFlightNo(flightNo);

            if(flightDetails==null){
                return new FlightDetails();
            }

            return flightDetails;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Bookings getUserBooking(String bookingId) {
        try{
            Bookings bookings=bookingRepository.findByBookingId(bookingId);

            if(bookings==null){
                return new Bookings();
            }
            return bookings;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public BookingIdList getAllBookingById() {
        try{
            List<Bookings> bookings=bookingRepository.findAll();

            BookingIdList bookingIdList=new BookingIdList();

            List<String> bookingId=new ArrayList<>();

            for(Bookings bookings1:bookings){
                bookingId.add(bookings1.getBookingId());
            }

            bookingIdList.setBookingIdList(bookingId);

            return bookingIdList;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}

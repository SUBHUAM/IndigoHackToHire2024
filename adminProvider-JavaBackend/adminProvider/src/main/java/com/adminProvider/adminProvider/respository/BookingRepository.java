package com.adminProvider.adminProvider.respository;

import com.adminProvider.adminProvider.entity.Bookings;
import com.adminProvider.adminProvider.entity.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
    Bookings findByBookingId(String bookingId);
}

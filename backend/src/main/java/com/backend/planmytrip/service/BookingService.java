package com.backend.planmytrip.service;



import java.util.List;
import java.util.Map;

import com.backend.planmytrip.dto.BookingDto;
import com.backend.planmytrip.entity.Booking;
import com.backend.planmytrip.entity.Package;



public interface BookingService {
	
	public List<Booking> getAllBookings();
	public BookingDto addBooking(BookingDto bookingDto);
	public Map<String, Object> getBookingDetail(Integer id);
	public List<Booking> getAllBookingById(Integer id);

}

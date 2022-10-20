package com.backend.planmytrip.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.planmytrip.dto.BookingDto;
import com.backend.planmytrip.entity.Activity;
import com.backend.planmytrip.entity.ActivityandPackage;
import com.backend.planmytrip.entity.AreaOfInterest;
import com.backend.planmytrip.entity.Booking;
import com.backend.planmytrip.entity.InterestandPackage;
import com.backend.planmytrip.entity.Package;
import com.backend.planmytrip.entity.Type;
import com.backend.planmytrip.entity.TypeandPackage;
import com.backend.planmytrip.helper.BookingDtoHelper;
import com.backend.planmytrip.repository.BookingRepo;
import com.backend.planmytrip.service.BookingService;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired private BookingRepo bookingRepo;
	@Autowired private BookingDtoHelper dtoHelper;

	@Override
	public BookingDto addBooking(BookingDto bookingDto) {
		
		
		Booking bookingAdded  = bookingRepo.save(dtoHelper.convertBookingDtoToBooking(bookingDto));
		return dtoHelper.convertBookingToBookingDto(bookingAdded);
	}
	@Override
	public Map<String, Object> getBookingDetail(Integer id) {
		Map<String, Object> response = new HashMap<>();
		Optional<Booking> booking1 = bookingRepo.findById(id);
		response.put("booking", booking1.get());

		return response;
	}

	@Override
	public List<Booking> getAllBookingById(Integer id) {
		
		List<Booking> bookings = bookingRepo.findAllByUserId(id);
		return bookings;
	}
	
	@Override
	public List<Booking> getAllBookings() {
		List<Booking> bookings = bookingRepo.findAll();
		return bookings;
	}
	
}
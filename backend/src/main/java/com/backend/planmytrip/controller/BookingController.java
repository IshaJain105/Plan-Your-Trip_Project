package com.backend.planmytrip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.planmytrip.dto.BookingDto;
import com.backend.planmytrip.entity.Booking;
import com.backend.planmytrip.entity.Package;
import com.backend.planmytrip.service.BookingService;


@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/booking")
public class BookingController {

	@Autowired private BookingService bookingService;
	//fetch booking by booking id
	@GetMapping("/booking-detail/{id}")
	public ResponseEntity<Map<String, Object>> getBookingDetail(@PathVariable Integer id) {
		Map<String, Object> response = bookingService.getBookingDetail(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//fetch all bookings by user id
	@GetMapping("/fetchAllBookingById/{id}")
	public List<Booking> getAllBookingById(@PathVariable Integer id) {
		return bookingService.getAllBookingById(id);
	}
	//fetch all bookings
	@GetMapping("/get-all-bookings")
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}


	
	// add booking
	@PostMapping("/addBooking")
	public ResponseEntity<Map<String, Object>> addBooking(@RequestBody BookingDto bookingDto) {
		Map<String, Object> response = new HashMap<>();

		BookingDto bookingAdded = bookingService.addBooking(bookingDto);
		response.put("booking", bookingAdded);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	
}
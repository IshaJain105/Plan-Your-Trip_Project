package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.BookingDto;
import com.backend.planmytrip.entity.Booking;



@Component
public class BookingDtoHelper {

	public Booking convertBookingDtoToBooking(BookingDto dto) {
		Booking booking1 = new Booking();
		BeanUtils.copyProperties(dto, booking1);
		return booking1;
	}
	
	public BookingDto convertBookingToBookingDto(Booking booking1) {
		BookingDto dto = new BookingDto();
		BeanUtils.copyProperties(booking1, dto);
		return dto;
	}
}

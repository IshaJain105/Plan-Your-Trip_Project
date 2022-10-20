package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.FlightDto;
import com.backend.planmytrip.entity.Flight;

@Component
public class FlightDtoHelper {

	public Flight convertFlightDtoToFlight(FlightDto dto) {
		Flight flight = new Flight();
		BeanUtils.copyProperties(dto, flight);
		return flight;
	}
	
	public FlightDto convertFlightToFlightDto(Flight flight) {
		FlightDto dto = new FlightDto();
		BeanUtils.copyProperties(flight, dto);
		return dto;
	}
}

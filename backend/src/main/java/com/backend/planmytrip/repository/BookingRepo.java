package com.backend.planmytrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.Booking;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{
	List<Booking> findAllByUserId(Integer id);
}

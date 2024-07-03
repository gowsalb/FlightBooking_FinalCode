package com.javatpoint.LoginAndRegistrationPage.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javatpoint.LoginAndRegistrationPage.Entity_File.Passangers;

public interface PassangerDetailsRepository extends JpaRepository<Passangers, Long> {
	@Query("SELECT p FROM Passangers p WHERE p.passportNumber = ?1")
	public Passangers findByPassportNumber(String passportNumber);
	@Query("SELECT p FROM Passangers p WHERE p.BookingID = ?1")
	public List<Passangers> findByBookingID(String BookingID);
	@Query("SELECT p FROM Passangers p WHERE p.UserID = ?1")
	public List<Passangers> findByCustomerID(Long UserID);
	
//	@Query("SELECT p FROM Passangers p WHERE p.bookingID = ?1")
//	boolean existsByBookingID(String BookingID);
}

package com.javatpoint.LoginAndRegistrationPage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javatpoint.LoginAndRegistrationPage.Entity_File.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	@Query("SELECT f FROM Flight f WHERE f.flightName = ?1")
	public Flight findByflightName(String flightName);
	@Query("SELECT f FROM Flight f WHERE f.flightCode = ?1")
	public Flight findByflightCode(int flightCode);
}

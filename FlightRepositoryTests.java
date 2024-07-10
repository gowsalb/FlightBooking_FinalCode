package com.javatpoint.LoginAndRegistrationPage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.javatpoint.LoginAndRegistrationPage.Entity_File.Flight;
import com.javatpoint.LoginAndRegistrationPage.ServiceFiles.FlightDetailsService;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class FlightRepositoryTests {


	@Autowired
	private FlightDetailsService flightDetailsService;
	
	@Test
	public void testCreateFlight() {
		Flight flight = new Flight();
		flight.setFlightCode(13);
		flight.setFlightName("Deccan Air IN_MB-CA");
		flight.setArrivalCity("Mumbai");
		flight.setDepartureCity("Canada");
		flight.setNoOfSeatsAvailable(12);
		flight.setJourneyStartTime("2024-08-01 12:00:00");
		flight.setJourneyEndTime("2024-08-01 23:00:00");
		flight.setPricePerSeat("12000.00");
		flight.setCompanyName("Worthy wood");
		flightDetailsService.saveFlight(flight);
	}
	
	@Test
	public void testFindByFlightCode() {
		int flightCode = 13;
		Flight flight = flightDetailsService.getFlightByFlightCode(flightCode);
		assertThat(flight.getFlightCode()).isEqualTo(flightCode);
	}

}

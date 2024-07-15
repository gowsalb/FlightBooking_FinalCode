package com.javatpoint.LoginAndRegistrationPage.Entity_File;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlightTest {

	@Test
	void testGetSetPricePerSeat() {
		Flight flight = new Flight();
		String PricePerSeat = "20000";
		flight.setPricePerSeat(PricePerSeat);
		assertEquals(PricePerSeat, flight.getPricePerSeat());
	}

	@Test
	void testGetSetNoOfSeatsAvailable() {
		Flight flight = new Flight();
		int NoOfSeatsAvailable = 100;
		flight.setNoOfSeatsAvailable(NoOfSeatsAvailable);
		assertEquals(NoOfSeatsAvailable, flight.getNoOfSeatsAvailable());
	}

	@Test
	void testGetSetJourneyStartTime() {
		Flight flight = new Flight();
		String JourneyStartTime = "2024-07-28 01:00:00";
		flight.setJourneyStartTime(JourneyStartTime);
		assertEquals(JourneyStartTime,flight.getJourneyStartTime());
	}

	@Test
	void testGetSetJourneyEndTime() {
		Flight flight = new Flight();
		String JourneyEndTime = "2024-07-28 01:00:00";
		flight.setJourneyEndTime(JourneyEndTime);
		assertEquals(JourneyEndTime,flight.getJourneyEndTime());
	}

	@Test
	void testGetSetId() {
		Flight flight = new Flight();
		long id = 30;
		flight.setId(id);
		assertEquals(id,flight.getId());
	}

	@Test
	void testGetSetFlightName() {
		Flight flight = new Flight();
		String flightName = "Luftansa airline";
		flight.setFlightName(flightName);
		assertEquals(flightName,flight.getFlightName());
	}

	@Test
	void testGetSetFlightCode() {
		Flight flight = new Flight();
		int flightCode = 30;
		flight.setFlightCode(flightCode);
		assertEquals(flightCode,flight.getFlightCode());
	}

	@Test
	void testGetSetDepartureCity() {
		Flight flight = new Flight();
		String DepartureCity = "Chennai";
		flight.setDepartureCity(DepartureCity);
		assertEquals(DepartureCity,flight.getDepartureCity());
	}

	@Test
	void testGetArrivalCity() {
		Flight flight = new Flight();
		String ArrivalCity = "Mumbai";
		flight.setArrivalCity(ArrivalCity);
		assertEquals(ArrivalCity,flight.getArrivalCity());
	}


	@Test
	void testGetSetCompanyName() {
		Flight flight = new Flight();
		String CompanyName = "Thai Airways pvt limited";
		flight.setCompanyName(CompanyName);
		assertEquals(CompanyName,flight.getCompanyName());
	}
}

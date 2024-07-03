package com.javatpoint.LoginAndRegistrationPage.ServiceFiles;

import com.javatpoint.LoginAndRegistrationPage.Entity_File.Flight;

public class FlightDetails{

	private Flight flight;
	
	public FlightDetails(Flight flight) {
		this.flight = flight;
	}
	
	public String getFlightName() {
		return flight.getFlightName();
	}
	
	public int getFlightCode() {
		return flight.getFlightCode();
	}
	
	public String getDepartureCity() {
		return flight.getDepartureCity();
	}
	
	public String getArrivalCity() {
		return flight.getArrivalCity();
	}
	
	public String getCompanyName() {
		return flight.getCompanyName();
	}
	
	public int getNoOfSeatsAvailable() {
		return flight.getNoOfSeatsAvailable();
	}
	
	public String getJourneyStartTime() {
		return flight.getJourneyStartTime();
	}
	
	public String getJourneyEndTime() {
		return flight.getJourneyEndTime();
	}
	
	public String PricePerSeat() {
		return flight.getPricePerSeat();
	}
}

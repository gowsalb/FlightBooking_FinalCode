package com.javatpoint.LoginAndRegistrationPage.ServiceFiles;

import java.math.BigDecimal;
import java.util.List;

import com.javatpoint.LoginAndRegistrationPage.Entity_File.Flight;
import com.javatpoint.LoginAndRegistrationPage.Entity_File.Passangers;

public class PassangerDetails {
	
	private Passangers passengers;
	
	public PassangerDetails(Passangers passengers) {
		this.passengers = passengers;
	}
	
	public String getfirstName() {
		return passengers.getFirstName();
	}
	
	public String getlastName() {
		return passengers.getLastName();
	}
	
	public String getemailID() {
		return passengers.getEmailID();
	}
	
	public int getAge() {
		return passengers.getAge();
	}
	
	public String getPassportNumber() {
		return passengers.getPassportNumber();
	}
	
	public Long getUserID() {
		return passengers.getUserID();
	}
	
	public String getBookingID() {
		return passengers.getBookingID();
	}
	
	public int getflightCode() {
		return passengers.getFlightCodeSelected();
	}
	
	public BigDecimal getBookingPrice() {
		return passengers.getPriceOfBooking();
	}
	
	public String getBookingStatus() {
		return passengers.getBookingStatus();
	}
	
	public String getPassengerFullName() {
		return passengers.getFirstName() + " " + passengers.getLastName();
	}
}

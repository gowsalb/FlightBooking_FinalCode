package com.javatpoint.LoginAndRegistrationPage.Entity_File;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="passanger")
public class Passangers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false, length = 60)
	private String firstName;
	
	@Column(nullable = false, length = 60)
	private String lastName;
	
	@Column(name="email_ID",nullable = false, unique = true, length = 45)
	private String emailID;
	
	@Column(nullable = false, length = 3)
	private int age;
    
	@Column(name="passportNumber",nullable = false, unique = true, length = 30)
	private String passportNumber;
	
	@Column(name="CustomerID",nullable = false, length = 30)
	private Long UserID;
	
	@Column(name="BookingID",nullable = false, length = 30)
	private String BookingID;
	
	@Column(name="flightCode",nullable = false, length = 4)
	private int flightCodeSelected;
	
	@Column(name="priceOfBooking",nullable = false, length = 4)
	private BigDecimal priceOfBooking;
	
	@ManyToOne
	@JoinColumn(name="flightCode",referencedColumnName="flightCode",insertable=false,updatable=false)
	private Flight flight;
	
	@Column(name="BookingStatus",nullable = false, length = 30)
	private String BookingStatus;
	
	// Getters and Setters added

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Long getUserID() {
		return UserID;
	}

	public void setUserID(Long userID) {
		this.UserID = userID;
	}

	public String getBookingID() {
		return BookingID;
	}

	public void setBookingID(String bookingID) {
		BookingID = bookingID;
	}


	public int getFlightCodeSelected() {
		return flightCodeSelected;
	}

	public void setFlightCodeSelected(int flightCodeSelected) {
		this.flightCodeSelected = flightCodeSelected;
	}

	public BigDecimal getPriceOfBooking() {
		return priceOfBooking;
	}

	public void setPriceOfBooking(BigDecimal priceOfBooking) {
		this.priceOfBooking = priceOfBooking;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getBookingStatus() {
		return BookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		BookingStatus = bookingStatus;
	}
	
	
}

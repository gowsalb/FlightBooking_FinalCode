package com.javatpoint.LoginAndRegistrationPage.Entity_File;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable = false, unique = true, length = 60)
	private String flightName;
	
	@Column(nullable = false, length = 30)
	private int flightCode;
	
	@Column(nullable = false, length = 70)
	private String DepartureCity;
	
	@Column(nullable = false, length = 70)
	private String ArrivalCity;
    
	@Column(nullable = false, length = 100)
	private String CompanyName;
	
	@Column(nullable = false, length = 100)
	private int NoOfSeatsAvailable;
	
	@Column(nullable = false, length = 100)
	private String JourneyStartTime;
	
	@Column(nullable = false, length = 100)
	private String JourneyEndTime;
	
	@Column(name="Cost_per_ticket" ,nullable = false, length = 100)
	private String PricePerSeat;
	
	@OneToMany(mappedBy="flight")
	private List<Passangers> passengers;
	
	//Getters and Setters added

	public String getPricePerSeat() {
		return PricePerSeat;
	}

	public void setPricePerSeat(String pricePerSeat) {
		PricePerSeat = pricePerSeat;
	}

	public int getNoOfSeatsAvailable() {
		return NoOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		NoOfSeatsAvailable = noOfSeatsAvailable;
	}

	public String getJourneyStartTime() {
		return JourneyStartTime;
	}

	public void setJourneyStartTime(String journeyStartTime) {
		JourneyStartTime = journeyStartTime;
	}

	public String getJourneyEndTime() {
		return JourneyEndTime;
	}

	public void setJourneyEndTime(String journeyEndTime) {
		JourneyEndTime = journeyEndTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(int flightCode) {
		this.flightCode = flightCode;
	}

	public String getDepartureCity() {
		return DepartureCity;
	}

	public void setDepartureCity(String departureCity) {
		DepartureCity = departureCity;
	}

	public String getArrivalCity() {
		return ArrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		ArrivalCity = arrivalCity;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

}


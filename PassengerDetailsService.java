package com.javatpoint.LoginAndRegistrationPage.ServiceFiles;
 
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.LoginAndRegistrationPage.Entity_File.Passangers;
import com.javatpoint.LoginAndRegistrationPage.Repositories.PassangerDetailsRepository;

 
@Service
public class PassengerDetailsService{	
	@Autowired
	private final PassangerDetailsRepository PassangerDetailsRepo;
	
	@Autowired
	public PassengerDetailsService(PassangerDetailsRepository PassangerDetailsRepo) {
		this.PassangerDetailsRepo=PassangerDetailsRepo;
	}

	public void saveForm(List<Passangers> passengers){
		PassangerDetailsRepo.saveAll(passengers);
		System.out.println("Action Executed");
	}
	
	
	public List<Passangers> getAllpassengersByBookingID(String BookingID){
		return PassangerDetailsRepo.findByBookingID(BookingID);
	}
	
	public List<Passangers> getAllpassengersByUserID(Long UserID){
		return PassangerDetailsRepo.findByCustomerID(UserID);
	}

	public String generateUniqueBookingId() {
		String bookingId = generateRandomId();
		return bookingId; 
		} 
	
	
	private static final String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int lengthOfBookingID = 10;
	private final Random random = new SecureRandom();
	private String generateRandomId() 
		{ 
			StringBuilder BookingidBuilder = new StringBuilder(lengthOfBookingID); 
			for (int i = 0; i < lengthOfBookingID; i++) { 
				BookingidBuilder.append(characters.charAt(random.nextInt(characters.length()))); 
				}
			return BookingidBuilder.toString(); 
		} 
	public List<Passangers> updateBookingStatus(String bookingID, String bookingNewStatus) { 
		List<Passangers> passengers = PassangerDetailsRepo.findByBookingID(bookingID);
		passengers.forEach(passenger -> passenger.setBookingStatus(bookingNewStatus));
		return PassangerDetailsRepo.saveAll(passengers);
		}
	
}

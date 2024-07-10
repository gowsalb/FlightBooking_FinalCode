package com.javatpoint.LoginAndRegistrationPage;
 
import static org.assertj.core.api.Assertions.assertThat;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.javatpoint.LoginAndRegistrationPage.Entity_File.Passangers;
import com.javatpoint.LoginAndRegistrationPage.ServiceFiles.PassengerDetailsService;
 
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class PassengerRepositoryTest {
	
	@Autowired
	private PassengerDetailsService passengerDetailsService;
	
	@Test
	public void testCreateFlight() {
		List<Passangers> passenger = new ArrayList<>();
		String firstname[] = {"Tester1","Tester2"};
		String lastname[] =  {"Tester1_1","Tester2_1"};
		String setEmailID[]=  {"JunitTester1@gmail.com","JunitTester2@gmail.com"};
		int setAge[] = {23,35} ;
		String passportNumber[] = {"PAS112233","PAS445566"};
		long userID[]= {2,3};
		String BookingID[] = {"GHGH6667","GHGH6668"};
		String BookingStatus[]= {"Booked","Cancelled"};
		Double PriceOfBooking[] = {20000.50,30000.80};
		int selectedFlightCode[] = {12,13};
		
		for (int i=0;i<firstname.length;i++) {
		Passangers passengerIndividual =  new Passangers();
		passengerIndividual.setFirstName(firstname[i]);
		passengerIndividual.setLastName(lastname[i]);
		passengerIndividual.setEmailID(setEmailID[i]);
		passengerIndividual.setAge(setAge[i]);
		passengerIndividual.setPassportNumber(passportNumber[i]);
		passengerIndividual.setUserID(new Long(userID[i]));
		passengerIndividual.setBookingID(BookingID[i]);
		passengerIndividual.setBookingStatus(BookingStatus[i]);
		passengerIndividual.setPriceOfBooking(new BigDecimal(PriceOfBooking[i]));
		passengerIndividual.setFlightCodeSelected(selectedFlightCode[i]);
		passenger.add(passengerIndividual);
		}
		passengerDetailsService.saveForm(passenger);
	}
	
	@Test
	public void testFindByBookingID() {
		String BookingID_1 = "GHGH6667";
		String BookingID_2 = "GHGH6668";
		
		List<Passangers> passenger = passengerDetailsService.getAllpassengersByBookingID(BookingID_1);
		for(int i=0;i<passenger.size();i++) {
		assertThat(passenger.get(i).getBookingID()).isEqualTo(BookingID_1);
		}
		
		List<Passangers> passengerNew = passengerDetailsService.getAllpassengersByBookingID(BookingID_2);
		for(int i=0;i<passengerNew.size();i++) {
		assertThat(passengerNew.get(i).getBookingID()).isEqualTo(BookingID_2);
		}
	}
 
}

package com.javatpoint.LoginAndRegistrationPage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javatpoint.LoginAndRegistrationPage.Entity_File.Flight;
import com.javatpoint.LoginAndRegistrationPage.Entity_File.Passangers;
import com.javatpoint.LoginAndRegistrationPage.Repositories.FlightRepository;
import com.javatpoint.LoginAndRegistrationPage.Repositories.PassangerDetailsRepository;
import com.javatpoint.LoginAndRegistrationPage.ServiceFiles.FlightDetails;
import com.javatpoint.LoginAndRegistrationPage.ServiceFiles.FlightDetailsService;
import com.javatpoint.LoginAndRegistrationPage.ServiceFiles.PassangerDetails;
import com.javatpoint.LoginAndRegistrationPage.ServiceFiles.PassengerDetailsService;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	private final PassengerDetailsService passengerDetailsService;
	
	private final FlightDetailsService flightDetailsService;
	
	@Autowired
	public AppController(PassengerDetailsService passengerDetailsService,FlightDetailsService flightDetailsService) {
		this.passengerDetailsService=passengerDetailsService;
		this.flightDetailsService=flightDetailsService;
	}
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
//	@GetMapping("/login")
//	public String viewLoginPage() {
//		return "login";
//	}
	
	@GetMapping("/error")
	public String viewErrorPage() {
		return "error";
	}
	
	@GetMapping("/logout_success")
	public String viewLogoutSuccessPage() {
		return "logout_success";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@PostMapping("/process_register_Flightdetails")
	public String processRegisterFlightDetails(Flight flight) {		
		flightRepo.save(flight);
		
		return "FlightDetails_Saved_Success";
	}
	
	
	@GetMapping("/users")
	public String listFlights(Model model) {
		List<Flight> listFlights = flightRepo.findAll();
		model.addAttribute("listFlight", listFlights);
		
		return "users";
	}
	
	@GetMapping("/admin/home")
    public String adminHome(Model model) {
		model.addAttribute("flight", new Flight());
        return "adminHome";
    }
	
	/* @GetMapping("/PassangerCount")
	public String EnterPassangerDetails(@RequestParam("flightCode") int flightCode, Model model,@AuthenticationPrincipal CustomUserDetails user) {
		Flight flightData = flightRepo.findByflightCode(flightCode);
		model.addAttribute("Individualflight", flightData);
		model.addAttribute("passenger", new Passangers());
		PassangerDetails passangerDetails = new PassangerDetails();
		model.addAttribute("passangerDetails",passangerDetails);
		passangerDetails.setUserID(user.getUserID());
		Long UserID =  passangerDetails.getUserID();
		model.addAttribute("UserID_New", UserID);
        return "EnterPassangerDetails";
    }
	
	
	 @PostMapping("/process_register_Passangerdetails")
	public String process_register_Passangerdetails(Passangers passenger) {		
		passengerRepo.save(passenger);
		
		return "FlightDetails_Saved_Success";
	}
	*/
	
	@GetMapping("/PassangerCount")
	public String EnterPassangerDetails(@RequestParam("flightCode") int flightCode, Model model) {
		Flight flightData = flightRepo.findByflightCode(flightCode);
		model.addAttribute("Individualflight", flightData);
		model.addAttribute("passenger", new Passangers());
        return "EnterPassangerDetails";
    }
	
	
	@PostMapping("/process_register_Passangerdetails")
	public String process_register_Passangerdetails(@ModelAttribute PassangerDetails
			passengerdetails,@RequestParam("firstName") List<String> firstName,@RequestParam("lastName") List<String> lastName,@RequestParam("emailID") List<String> emailID, @RequestParam("age") List<Integer> age,@RequestParam("passportNumber") List<String> passportNumber,@RequestParam("priceOfBooking") BigDecimal priceOfBooking, @RequestParam("selectedFlightCode") int selectedFlightCode,Model model,@AuthenticationPrincipal CustomUserDetails user,FlightDetails flightdetails,Flight flight) {
		List<Passangers> passangers = new ArrayList<>();
		String BookingID = passengerDetailsService.generateUniqueBookingId();
		int size = passportNumber.size();
		int selectedCode = selectedFlightCode;
		String BookingStatus = "Booked";
		for (int i=0 ; i<size;i++) {
			Passangers passenger =  new Passangers();
			passenger.setFirstName(firstName.get(i));
			passenger.setLastName(lastName.get(i));
			passenger.setAge(age.get(i));
			passenger.setEmailID(emailID.get(i));
			passenger.setPassportNumber(passportNumber.get(i));
			passenger.setUserID(user.getUserID());
			passenger.setBookingID(BookingID);
			passenger.setFlightCodeSelected(selectedCode);
			passenger.setPriceOfBooking(priceOfBooking);
			passenger.setBookingStatus(BookingStatus);
			passangers.add(passenger);
		}
		int newAvailableSeats = flightDetailsService.getFlightByFlightCode(selectedFlightCode).getNoOfSeatsAvailable()-size;
		flightDetailsService.updateAvailableSeats(selectedFlightCode, newAvailableSeats);
		passengerDetailsService.saveForm(passangers);
		model.addAttribute("passengerList",passengerDetailsService.getAllpassengersByBookingID(BookingID));
		model.addAttribute("bookingID",BookingID);
		return "BookingSuccess";
	}
	
	@GetMapping("/BookingSuccess")
	public String BookingConfirmation(){
		return "BookingSuccess";
	}
	
	@GetMapping("/BookingHistory")
	public String bookinghistory(Model model,@AuthenticationPrincipal CustomUserDetails user){
		Long userID = user.getUserID();
		List<Passangers> passangers =passengerDetailsService.getAllpassengersByUserID(userID);
		model.addAttribute("listPassengers", passangers);
		return "BookingHistory";
	}

}

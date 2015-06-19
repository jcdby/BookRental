package kr.ac.ajou.lazybones.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import kr.ac.ajou.lazybones.entitymanager.ReservationEntityManagerImpl;
import kr.ac.ajou.lazybones.templates.Reservation;
import kr.ac.ajou.lazybones.templates.ReservationService;
import kr.ac.ajou.lazybones.templates.Result;
import kr.ac.ajou.lazybones.templates.Service;
import kr.ac.ajou.lazybones.templates.ServiceProviderRegistrationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
//This Component will send the information about this Service Provider when SP server initiated.
public class ReservationRESTController {
	
	private String registrationAddress = "http://210.107.197.150:8080/PAmanager/webresources/Service/Register";//PA(Personal Assisstant) server address
			//The Personal Assisstant system server address.
	
	@Autowired
	private ReservationEntityManagerImpl resvEntityManagerImpl;

	
	@PostConstruct
	//This method is used for registering it to PA System.
	public void RegisterServiceProvider(){

		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		//Register Service Provider when initiation.
		//(Include SP name, and the place where can get the services from uri.)
		System.out.println("I am in!");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ServiceProviderRegistrationForm form = new ServiceProviderRegistrationForm();
		form.setSp("Book Rental");
		
		Service[] services = new Service[2];
		services[0] = new Service();
		services[0].setName("Book Search");
		services[0].setUrl("http://210.107.197.213:8080/BookRental/Book");
		services[1] = new Service();
		services[1].setName("My Reservations");
		services[1].setUrl("http://210.107.197.213:8080/BookRental/Reservation");
		
		form.setServices(services);
		
		ReservationService[] rServices = new ReservationService[1];
		rServices[0] = new ReservationService();
		rServices[0].setName("Book Reservations");
		rServices[0].setUrl("http://210.107.197.213:8080/BookRental/REST/Reservations");
		
		form.setReservationServices(rServices);
		
		try {
			System.out.println(mapper.writeValueAsString(form).toString());
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpEntity<String> entity;
		try {
			entity = new HttpEntity<String>(mapper.writeValueAsString(form).toString(), headers);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		Result result = restTemplate.postForObject(registrationAddress, entity, Result.class);
			
		System.out.println(result);
		
		if (result.getResult().equals("OK")) {
			System.out.println("Registration succeed!");

		} else
			System.out.println("Registeration is failed");

	}
	
	@PreDestroy
	public void unregisterServiceProvider(){
		//Unregister service provider when destroy
		
	}
	
	@RequestMapping(value = "/REST/Reservations", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public List<Reservation> getReservations(@RequestBody String uid){
		List<Reservation> reservations = new ArrayList<>();
		
		List<kr.ac.ajou.lazybones.repos.entities.Reservation> list = resvEntityManagerImpl.findReservationsByUid(uid);
		for(kr.ac.ajou.lazybones.repos.entities.Reservation item : list){
			Reservation resv = new Reservation();
			resv.setName(item.getBook().getTitle());
			resv.setFrom(item.getFrom());
			resv.setTo(item.getTo());
			reservations.add(resv);
		}
		return reservations;
	}
//	
//	@RequestMapping(value = "/GetServicesRegisterEntry/{Name}", method = RequestMethod.GET)
//	public void getServices(){
//		
//	}
}


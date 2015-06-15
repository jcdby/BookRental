package kr.ac.ajou.lazybones.restcontrollers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ReservatoinRESTController {
	private String getregAddress = "http://localhost:8080/"//PA(Personal Assisstant) server address
			+ "PAmanager/webresources/RegisterServiceProvider/{SPname}/{ServiceName}/{RedirectionAddress}";//The Personal Assisstant system server address.
	
	//the Service Provider name for registration
	private final String SPname = "BookRental";
	//the name for retrieving the services in this Service Provider.
	//uri should be where PA can get services from uri.
	private final String ServiceEntryUri = "localhost%3A8090%2FWasherMan%2FGetServicesRegisterEntry";
	
		
	
	private RestTemplate restTempleate = new RestTemplate();
	
	@PostConstruct
	//This method is used for registering it to PA System.
	public void RegisterServiceProvider(){
		
		//Register Service Provider when initiation.
		//(Include SP name, and the place where can get the services from uri.)
		System.out.println("I am in!");
		String result = restTempleate.getForObject(getregAddress, String.class, SPname, "Reservation", ServiceEntryUri);
		
		System.out.println(result);
		
		if(!result.equals("OK"))
		{
			System.out.println("Registeration is failed");
		}
		
	}
	

}

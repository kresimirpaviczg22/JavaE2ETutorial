package com.eviden.e2e;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.eviden.e2e.model.Car;
import com.eviden.e2e.model.Contract;
import com.eviden.e2e.model.Engine;
import com.eviden.e2e.model.Organisation;
import com.eviden.e2e.model.User;
import com.eviden.e2e.repository.CarRepository;
import com.eviden.e2e.repository.ContractRepository;
import com.eviden.e2e.repository.EngineRepository;
import com.eviden.e2e.repository.OrganisationRepository;
import com.eviden.e2e.repository.UserRepository;

import jakarta.transaction.Transactional;

@EnableScheduling
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class E2EApplication {
	
	@Autowired
	ContractRepository contractRepository;
	
	@Autowired
	OrganisationRepository organisationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	EngineRepository engineRepository;

	public static void main(String[] args) {
		SpringApplication.run(E2EApplication.class, args);
	}

	@Transactional
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    System.out.println("hello world, I have just started up");
	    
//	    Car newCar = new Car();
//	    newCar.setMake("Ford");
//	    newCar.setModel("Falcon");
//	    newCar.setManufacturingYear(1970);
//	    newCar.setVin("5GZCZ43D13S812715");
//	    
//	    Car newerCar = new Car();
//	    newerCar.setMake("Tesla");
//	    newerCar.setModel("Model S");
//	    newerCar.setManufacturingYear(2023);
//	    newerCar.setVin("5YJSA1E26PF123456");
//	    
//	    Car classicCar = new Car();
//	    classicCar.setMake("Chevrolet");
//	    classicCar.setModel("Bel Air");
//	    classicCar.setManufacturingYear(1957);
//	    classicCar.setVin("VC57S123456");
//	   
//	    System.out.println("Created cars " + newCar + newerCar + classicCar);
//	    
//	    Engine newEngine = new Engine();
//	    newEngine.setManufacturer("Ford");
//	    newEngine.setModel("351 Cleveland");
//	    newEngine.setManufacturingYear(1969);
//	    newEngine.setEngineType(Engine.EngineType.PETROL);
//	    newEngine.setVolume(5500);
//	    
//	    Engine newerEngine = new Engine();
//	    newerEngine.setManufacturer("Tesla");
//	    newerEngine.setModel("Plaid Electric Motor");
//	    newerEngine.setManufacturingYear(2023);
//	    newerEngine.setEngineType(Engine.EngineType.ELECTRIC);
//	    
//	    Engine classicEngine = new Engine();
//	    classicEngine.setManufacturer("Chevrolet");
//	    classicEngine.setModel("Small-Block 283 V8");
//	    classicEngine.setManufacturingYear(1957);
//	    classicEngine.setEngineType(Engine.EngineType.PETROL);
//	    classicEngine.setVolume(4638);
//	    
//	    System.out.println("Created engines " + newEngine + newerEngine + classicEngine);
//	    
//	    newCar.setEngine(newEngine);
//	    newerCar.setEngine(newerEngine);
//	    classicCar.setEngine(classicEngine);
//
//	    carRepository.save(newCar);
//	    carRepository.save(newerCar);
//	    carRepository.save(classicCar);
//	    
//	    System.out.println("Added car and engine to db...");
//	    
//	    
//	    
//	    Contract newContract = new Contract();
//	    newContract.setName("Prvi ugovor");
//	    newContract.setNumber("11-22-CD");
//	    newContract.setYear(2024);
//	    newContract.setStartDate(LocalDate.now());
//	    newContract.setType("Frame");
//	    newContract.setVersion("1.1");
//	    
//	    contractRepository.save(newContract);
//	    
//	    System.out.println("Created contract...");
//	    System.out.println(newContract);
//	    
//	    Organisation newOrganisation = new Organisation();
//	    newOrganisation.setName("Prva organizacija");
//	    newOrganisation.setAddress("Ulica Andrije Kacica Miosica 62");
//	    newOrganisation.setCity("Velika Gorica");
//	    newOrganisation.setCountry("Hrvatska");
//	    newOrganisation.setFoundedDate(LocalDate.now());
//	    
//	    organisationRepository.save(newOrganisation);
//	    
//	    System.out.println("Created organisation...");
//	    System.out.println(newOrganisation);
//	   
//	    User newUser = new User();
//	    newUser.setUsername("korisnik1");
//	    newUser.setEmail("korisnik1@gmail.com");
//	    newUser.setActive(true);
//	    newUser.setOrganisation(newOrganisation);
//	
//	    userRepository.save(newUser);
//	    
//	    System.out.println("Created first user...");
//	    System.out.println(newUser);
//	    
//	    User newUser2 = new User();
//	    newUser2.setUsername("korisnik2");
//	    newUser2.setEmail("korisnik2@gmail.com");
//	    newUser2.setActive(false);
//	    newUser2.setOrganisation(newOrganisation);
//	    
//	    userRepository.save(newUser2);
//	    
//	    System.out.println("Created second user...");
//	    System.out.println(newUser2);
//	   
//	    Organisation organisation = new Organisation();
//	    organisation = organisationRepository.selectById((long) 702);
//	    
//	    if (organisation != null ) {
//	    	System.out.println(organisation.getName());
//	    }
//	    System.out.println(organisation!=null ? organisation.getName() : "N/A");
//	   
//	    List<User> users = userRepository.selectById((long) 602);
//	    users.forEach(user -> System.out.println(user.getEmail()));
//	   
//	    Organisation organisation2 = new Organisation();
//	    organisation2 = organisationRepository.selectOrganisationAndUsers((long) 702);
//	    System.out.println(organisation2.getName());
//	    System.out.println(organisation2);
//	    
//	    userRepository.updateNameById("user1", (long) 702);
//	    
//	    organisationRepository.updateNameById("novaFirma", (long) 802);
//	    organisationRepository.deleteById((long) 652);
	    
	}
}

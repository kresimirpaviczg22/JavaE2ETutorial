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

import com.eviden.e2e.model.Organisation;
import com.eviden.e2e.model.User;
import com.eviden.e2e.repository.ContractRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(E2EApplication.class, args);
	}

	@Transactional
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    System.out.println("hello world, I have just started up");
	    
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
//	    newOrganisation.setName("Eviden");
//        newOrganisation.setAddress("Heinzelova 20");
//	    newOrganisation.setCity("Zagreb");
//	    newOrganisation.setState("Zagrebačka županija");
//	    newOrganisation.setCountry("Hrvatska");
//	    newOrganisation.setFoundedDate(LocalDate.now());
//	    
//	    organisationRepository.save(newOrganisation);
//	    System.out.println("Created organisation...");
//	    
//	    User newUser = new User();
//        newUser.setUsername("tmartincic");
//	    newUser.setEmail("tmartincic@eviden.com");
//	    newUser.setActive(true);
//	    newUser.setOrganisation(newOrganisation);
//	   
//	    userRepository.save(newUser);
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
//	    System.out.println(organisation.getName());
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

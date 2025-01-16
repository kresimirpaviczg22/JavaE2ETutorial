package com.eviden.e2e;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.eviden.e2e.model.Contract;
import com.eviden.e2e.repository.ContractRepository;

@SpringBootApplication
public class E2EApplication {
	
	@Autowired
	ContractRepository contractRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(E2EApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    System.out.println("hello world, I have just started up");
	    
	    Contract newContract = new Contract();
	    newContract.setName("Prvi ugovor");
	    newContract.setNumber("11-22-CD");
	    newContract.setYear(2024);
	    newContract.setStartDate(LocalDate.now());
	    newContract.setType("Frame");
	    newContract.setVersion("1.1");
	    
	    contractRepository.save(newContract);
	    
	    System.out.println("Created contract...");
	    System.out.println(newContract);
	}
}

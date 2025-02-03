package com.eviden.e2e.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.eviden.e2e.repository.OrganisationRepository;

import jakarta.transaction.Transactional;

@Component
public class scheduledTask {

	@Autowired
	private OrganisationRepository orgRepository;
	

	@Scheduled(cron = "${scheduled.licenceTrendUpdaterJob.cron}")
	@Transactional
	public void updateLicenceTrendReport(){
		
		Long orgCount = orgRepository.getOrganisationCount();
		System.out.println("Task is running every 10 seconds");
		System.out.println(orgCount);
	}

}
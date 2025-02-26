package com.eviden.e2e.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.eviden.e2e.repository.OrganisationRepository;

@Component
public class ScheduledTask {

	Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	
	@Autowired
	private OrganisationRepository orgRepository;
	

	//@Scheduled(cron = "${scheduled.licenceTrendUpdaterJob.cron}")
	public void updateLicenceTrendReport(){
		
		Long orgCount = orgRepository.getOrganisationCount();
		
		log.info("Task is running every 10 seconds... The number of orgs is" + orgCount);
	}

}
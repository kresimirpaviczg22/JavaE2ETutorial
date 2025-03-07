package com.eviden.e2e.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import java.util.Date;  
//import org.quartz.Job;  
//import org.quartz.JobExecutionContext;  
//import org.quartz.JobExecutionException;  

import com.eviden.e2e.repository.OrganisationRepository;

@Component
public class ScheduledTask implements Job {

	Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	
	@Autowired
	private OrganisationRepository orgRepository;
	
	
//	@Scheduled(cron = "${scheduled.licenceTrendUpdaterJob.cron}")
//	@Transactional
//	public void updateLicenceTrendReport(){
//		
//		Long orgCount = orgRepository.getOrganisationCount();
//		
//		log.info("Task is running every 10 seconds... The number of orgs is " + orgCount);
//	}


	@Override
	@Transactional
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		Long orgCount = orgRepository.getOrganisationCount();
		
		//log.info("Task is running every 10 seconds... The number of orgs is " + orgCount);
	}
		
}




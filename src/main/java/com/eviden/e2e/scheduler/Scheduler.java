package com.eviden.e2e.scheduler;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Scheduler {
	
    @Value("${scheduled.licenceTrendUpdaterJob.cron}")
    private String cronExpression;  // Injecting cron expression from properties
	
    @Bean
    public JobDetail scheduledTaskJobDetail() {
        return JobBuilder.newJob(ScheduledTask.class)
                .withIdentity("scheduledTask")
                .storeDurably()
                .build();
    }
    
    @Bean
    public Trigger scheduledTaskJobTrigger(JobDetail scheduledTaskJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(scheduledTaskJobDetail)
                .withIdentity("scheduledTaskTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }
    
 
//	SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//	Scheduler scheduler = schedulerFactory.getScheduler();
	
}

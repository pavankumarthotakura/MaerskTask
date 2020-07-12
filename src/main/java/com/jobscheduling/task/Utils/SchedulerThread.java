package com.jobscheduling.task.Utils;


import static java.lang.Thread.sleep;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jobscheduling.task.Dtos.Scheduler;


public class SchedulerThread implements Runnable {

	Logger logger = LoggerFactory.getLogger(SchedulerThread.class);

	Scheduler scheduler;

	public SchedulerThread(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public void run() {
       logger.info("Job Started for UID {}",scheduler.getUID());
		scheduler.setStatus("Pending");
		scheduler.setSortValues(scheduler.getSortValues().stream().sorted().collect(Collectors.toList()));
		try {
			logger.info("thread is going to sleep with UID {}",scheduler.getUID());
			sleep(10000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		long sec = ChronoUnit.SECONDS.between(scheduler.getCreatedDate(), LocalDateTime.now());
		scheduler.setDuration(sec+" Seconds");
		scheduler.setStatus("Completed");

       logger.info("Job Ended for UID {}",scheduler.getUID());
	}

}

package com.jobscheduling.task.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobscheduling.task.Dtos.Job;
import com.jobscheduling.task.Dtos.JobRequest;
import com.jobscheduling.task.Dtos.JobsList;
import com.jobscheduling.task.Dtos.Scheduler;
import com.jobscheduling.task.Utils.SchedulerThread;

@Service
public class JobServiceImpl implements JobService {

	Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

	@Autowired
	ExecutorService executorService;

	@Autowired
	List<Scheduler> inMemory;

	@Override
	public Job jobSchedule(JobRequest jobRequest)	{
		String uid = UUID.randomUUID().toString();
        logger.info("UID created for request");

		Scheduler scheduler = new Scheduler();
		scheduler.setSortValues(jobRequest.getSortvalues());
		scheduler.setUID(uid);
		scheduler.setStatus("start");
		inMemory.add(scheduler);
		executorService.submit(new SchedulerThread(scheduler));
		scheduler.setCreatedDate(LocalDateTime.now());
		logger.info("Job Submitted to Scheduler With UID {}",uid);

		return new Job(uid);
	}

   @Override
   public JobsList getinMemoryData() {
		logger.info("showing inMemory db");
		return new JobsList(inMemory);
   }

   @Override
   public Scheduler getJobByUID(String id) {
		Optional<Scheduler> val = inMemory.stream()
				.filter(scheduler -> scheduler.getUID().equals(id)).findFirst();
		if(!val.isPresent()) {
			logger.error("id not found in inMemory db");
			throw new RuntimeException("id not found in db");
		}
	   logger.info("id found in inMemory db");
		return val.get();
   }

}

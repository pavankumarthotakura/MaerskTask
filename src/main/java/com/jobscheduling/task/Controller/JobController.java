package com.jobscheduling.task.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jobscheduling.task.Dtos.Job;
import com.jobscheduling.task.Dtos.JobRequest;
import com.jobscheduling.task.Dtos.JobsList;
import com.jobscheduling.task.Dtos.Scheduler;
import com.jobscheduling.task.Service.JobService;

@RestController
@RequestMapping(value = "job")
public class JobController {

	Logger logger = LoggerFactory.getLogger(JobController.class);

	@Autowired
	JobService jobService;

	@RequestMapping(value = "schedule", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	Job schedule(@RequestBody JobRequest jobRequest) {
		logger.info("Job Scheduler Request Triggered");
        return jobService.jobSchedule(jobRequest);
	}

   @RequestMapping(value = "list", method = RequestMethod.GET,
		   produces = MediaType.APPLICATION_JSON_VALUE)
   JobsList getinMemoryData() {
	   logger.info("getinMemoryData Request Triggered");
      return jobService.getinMemoryData();
   }

   @RequestMapping(value="/{id}", method = RequestMethod.GET,
		   produces = MediaType.APPLICATION_JSON_VALUE)
	Scheduler getJobByUID(@PathVariable String id) {
	   logger.info("getJobByUID Request Triggered");
		return jobService.getJobByUID(id);
   }

}

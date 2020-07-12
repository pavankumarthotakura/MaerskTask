package com.jobscheduling.task.Service;

import java.util.List;

import com.jobscheduling.task.Dtos.Job;
import com.jobscheduling.task.Dtos.JobRequest;
import com.jobscheduling.task.Dtos.JobsList;
import com.jobscheduling.task.Dtos.Scheduler;

public interface JobService {

	Job jobSchedule(JobRequest jobRequest);

	JobsList getinMemoryData();

	Scheduler getJobByUID(String id);
}

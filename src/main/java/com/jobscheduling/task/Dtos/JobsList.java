package com.jobscheduling.task.Dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobsList {

	public JobsList(List<Scheduler> jobsList) {
		this.jobsList = jobsList;
	}

	@JsonProperty("jobsList")
	List<Scheduler> jobsList = new ArrayList<>();

	public List<Scheduler> getJobsList() {
		return jobsList;
	}

	public void setJobsList(List<Scheduler> jobsList) {
		this.jobsList = jobsList;
	}
}

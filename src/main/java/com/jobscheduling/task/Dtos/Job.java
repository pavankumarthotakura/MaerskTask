package com.jobscheduling.task.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {

	public Job(String uid) {
		this.UID = uid;
	}

	@JsonProperty(value = "uid")
	String UID;

	public String getUID() {
		return UID;
	}

	public void setUID(String UID) {
		this.UID = UID;
	}
}

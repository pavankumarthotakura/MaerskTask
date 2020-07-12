package com.jobscheduling.task.Dtos;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Scheduler {

	@JsonProperty("uid")
	private String UID;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonProperty
	private LocalDateTime createdDate;

	@JsonProperty("sortValues")
	private List<Integer> sortValues = new ArrayList<>();

	@JsonProperty("status")
	private String status;

	@JsonProperty("duration")
	private String duration;


	public String getUID() {
		return UID;
	}

	public void setUID(String UID) {
		this.UID = UID;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<Integer> getSortValues() {
		return sortValues;
	}

	public void setSortValues(List<Integer> sortValues) {
		this.sortValues = sortValues;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}

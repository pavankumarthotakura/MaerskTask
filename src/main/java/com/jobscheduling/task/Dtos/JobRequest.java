package com.jobscheduling.task.Dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRequest {

	@JsonProperty(value = "sortvalues")
	List<Integer> sortvalues = new ArrayList<>();

	public List<Integer> getSortvalues() {
		return sortvalues;
	}

	public void setSortvalues(List<Integer> sortvalues) {
		this.sortvalues = sortvalues;
	}
}

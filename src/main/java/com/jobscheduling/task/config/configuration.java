package com.jobscheduling.task.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jobscheduling.task.Dtos.Scheduler;

@Configuration
public class configuration {

	@Bean
	List<Scheduler> inMemory() {
		return new ArrayList<Scheduler>();
	}

	@Bean
	ExecutorService threadPool() {
		return  Executors.newFixedThreadPool(1);
	}

}

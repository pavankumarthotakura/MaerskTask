package com.jobscheduling.task.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.jobscheduling.task.Dtos.Job;
import com.jobscheduling.task.Dtos.JobRequest;
import com.jobscheduling.task.Dtos.JobsList;
import com.jobscheduling.task.Dtos.Scheduler;
import com.jobscheduling.task.Utils.SchedulerThread;

@SpringBootTest
public class JobServiceImplTest {

	@InjectMocks
	JobServiceImpl jobService;

	@Mock
	ExecutorService executorService;

	@BeforeEach
	void setUp() {
		List<Scheduler> inMemory = new ArrayList<>();
		Scheduler sc = new Scheduler();
		sc.setStatus("completed");
		sc.setUID(UUID.randomUUID().toString());
		sc.setDuration("10 sec");
		sc.setSortValues(Arrays.asList(23, 24, 25));
		inMemory.add(sc);
		ReflectionTestUtils.setField(jobService, "inMemory", inMemory);
	}

	@Test
	void getinMemoryDataTest() {
		JobsList ls = jobService.getinMemoryData();
		assertEquals(1, ls.getJobsList().size());
	}

	@Test
	void jobScheduleTest() {
		JobRequest jobRequest = new JobRequest();
		jobRequest.setSortvalues(Arrays.asList(24, 25, 13));
		Job job = jobService.jobSchedule(jobRequest);
		assertNotNull(job);
		Mockito.verify(executorService, atLeastOnce()).submit(any(SchedulerThread.class));
	}


}

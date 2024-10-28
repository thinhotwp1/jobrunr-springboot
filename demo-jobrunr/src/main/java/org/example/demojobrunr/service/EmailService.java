package org.example.demojobrunr.service;

import org.example.demojobrunr.dto.EmailJobRequest;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.jobs.annotations.Recurring;
import org.jobrunr.jobs.context.JobContext;
import org.jobrunr.jobs.context.JobRunrDashboardLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements JobService {
    private static final Logger LOGGER = new JobRunrDashboardLogger(LoggerFactory.getLogger(EmailService.class));

    @Override
    @Job(name = "Send email to customer %0")
    public <I> void directProcess(I input, JobContext jobContext) {
        EmailJobRequest emailJobRequest = (EmailJobRequest) input;
        LOGGER.info("Sending email to " + emailJobRequest.getEmailList());
    }

    @Recurring(id = "recurring-job", cron = "0 0/15 * * *")
    @Job(name = "Send email schedule")
    public void doRecurringJob() {
        LOGGER.info("Do something in next 15 hours");
    }


    @Override
    @Job(name = "Double process email test")
    public <I> void flowProcess(I input, JobContext jobContext) {
        LOGGER.info("Double process");
//        this.directProcess(input, jobContext);
    }
}

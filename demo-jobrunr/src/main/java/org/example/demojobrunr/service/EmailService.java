package org.example.demojobrunr.service;

import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.jobs.annotations.Recurring;
import org.jobrunr.jobs.context.JobContext;
import org.jobrunr.jobs.context.JobRunrDashboardLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements JobService{
    private static final Logger LOGGER = new JobRunrDashboardLogger(LoggerFactory.getLogger(EmailService.class));

    @Override
    @Job(name = "Send email to customer %0")
    public <I> void directProcess(I input, JobContext jobContext) {
        LOGGER.info("Sending email to " + input);
        LOGGER.info("JobId: "+jobContext.getJobId());
        LOGGER.info("JobName: "+jobContext.getJobName());
        LOGGER.info("Metadata: "+jobContext.getMetadata());
        LOGGER.info("JobName: "+jobContext.getJobSignature());
        LOGGER.info("CreatedAt: "+jobContext.getCreatedAt());
    }

    @Recurring(id = "recurring-job", cron = "0 0/15 * * *")
    @Job(name = "Send email schedule")
    public void doRecurringJob() {
        LOGGER.info("Do something in next 15 hours");
    }
}

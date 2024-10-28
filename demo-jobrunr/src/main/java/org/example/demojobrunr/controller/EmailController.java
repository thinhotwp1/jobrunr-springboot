package org.example.demojobrunr.controller;

import org.example.demojobrunr.dto.EmailJobRequest;
import org.example.demojobrunr.service.EmailService;
import org.jobrunr.jobs.context.JobContext;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
public class EmailController {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailJobRequest emailJobRequest) {
//        // Chạy job ngay lập tức
//        BackgroundJob.enqueue(() -> emailService.directProcess(emailJobRequest, JobContext.Null));

        // Lên lịch job chạy sau 1 phút
        jobScheduler.schedule(Instant.now()
                        .plus(emailJobRequest.getHours(), ChronoUnit.HOURS)
                        .plus(emailJobRequest.getMinutes(), ChronoUnit.MINUTES)
                        .plus(emailJobRequest.getSeconds(), ChronoUnit.SECONDS),
                () -> emailService.directProcess(emailJobRequest, JobContext.Null));

        return "Job " + emailJobRequest.getJobName() + " created";
    }


//    @PostMapping("/double-process")
//    public String doubleProcess(@RequestBody EmailJobRequest emailJobRequest) {
//        BackgroundJob.enqueue(() -> emailService.flowProcess(emailJobRequest, JobContext.Null));
//
//        return "Job " + emailJobRequest.getJobName() + " created";
//    }
}

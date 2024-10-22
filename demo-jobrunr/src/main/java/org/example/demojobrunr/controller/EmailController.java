package org.example.demojobrunr.controller;

import org.example.demojobrunr.service.EmailService;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
public class EmailController {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam(defaultValue = "thinhld@telsoft.com.vn") String email,
                            @RequestParam(defaultValue = "1") Integer minutes) {
        // Chạy job ngay lập tức
        BackgroundJob.enqueue(() -> emailService.sendEmail(email));

        // Lên lịch job chạy sau 1 phút
        jobScheduler.schedule(Instant.now().plus(minutes, ChronoUnit.MINUTES),
                () -> emailService.sendEmail(email));

        return "Email job created!";
    }
}

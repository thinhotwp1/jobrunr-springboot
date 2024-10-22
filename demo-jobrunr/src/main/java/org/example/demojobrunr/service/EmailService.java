package org.example.demojobrunr.service;

import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Job(name = "Send email to customer %0")
    public void sendEmail(String customerEmail) {
        System.out.println("Sending email to " + customerEmail);
    }
}

package org.example.demojobrunr.service;

import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.jobs.context.JobContext;

public interface JobService {
    <I> void directProcess (I input, JobContext jobContext);
    <I> void flowProcess(I input, JobContext jobContext);
}

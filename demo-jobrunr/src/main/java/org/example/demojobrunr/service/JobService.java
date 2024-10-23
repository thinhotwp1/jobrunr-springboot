package org.example.demojobrunr.service;

import org.jobrunr.jobs.context.JobContext;

public interface JobService {
    <I> void directProcess (I input, JobContext jobContext);
}

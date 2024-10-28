package org.example.demojobrunr.dto;

import lombok.Data;

@Data
public abstract class JobRequestAbstract {
    private String jobName;
    private int minutes;
    private int hours;
    private int seconds;
}

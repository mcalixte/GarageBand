package com.soen343.gms.service;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.model.Task;

import java.util.List;

public interface JobService
{
    void saveJob(Job job);
    List<Job> getAllJobs();
    Job findJobById(long id);
    List<Job> findJobsByState(JobState state);
    Job findJobsByVin(long vin);
    Job update(Job job);
}

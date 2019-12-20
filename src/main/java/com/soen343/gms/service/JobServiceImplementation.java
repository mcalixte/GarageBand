package com.soen343.gms.service;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.model.Task;
import com.soen343.gms.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jobService")
public class JobServiceImplementation implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public void saveJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job findJobById(long id) { return jobRepository.findJobById(id); }


    public List<Job> findJobsByState(JobState state){ return jobRepository.findAllByState(state);}

    @Override
    public Job findJobsByVin(long vin) { return jobRepository.findJobByVin(vin);}

    @Override
    public Job update(Job job) { return jobRepository.save(job); }


}

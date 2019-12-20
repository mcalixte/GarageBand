package com.soen343.gms.repository;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    Job findJobById(long id);
    Job findJobByVin(long vin);
    List<Job> findAll();
    List<Job> findAllByState(JobState state);

}

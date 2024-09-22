package com.msb.firstjobapp.job.impl;

import com.msb.firstjobapp.job.Job;
import com.msb.firstjobapp.job.JobRepository;
import com.msb.firstjobapp.job.JobService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {
    private static final Logger log = LoggerFactory.getLogger(JobServiceImpl.class);
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findJobById(@NotNull Long id) {
        return jobRepository.findById(id);
    }


    @Override
    public void createJob(@NotNull Job job) {
        job.setId(null);
        jobRepository.save(job);
    }

    @Override
    public boolean updateJob(@NotNull Long id, @NotNull Job newJob) {
        if (jobRepository.findById(id).isPresent()) {
            newJob.setId(id);
            jobRepository.save(newJob);
            return true;
        }
        log.info("Job with id {} Not found. Update Canceled", id);
        return false;
    }

    @Override
    public boolean deleteJob(@NotNull Long id) {
        if (jobRepository.findById(id).isPresent()) {
            jobRepository.deleteById(id);
            return true;
        } else {
            log.info("Job with id {} Not found. Delete Canceled", id);
            return false;
        }
    }
}

package com.msb.firstjobapp.job.impl;

import com.msb.firstjobapp.job.Job;
import com.msb.firstjobapp.job.JobService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public Optional<Job> findJobById(@NotNull Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findAny();
    }


    @Override
    public void createJob(@NotNull Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public boolean updateJob(@NotNull Long id, @NotNull Job newJob) {
        AtomicBoolean flag = new AtomicBoolean(false);
        jobs = jobs.stream().map(job -> {
            if (job.getId().equals(id)) {
                flag.set(true);
                newJob.setId(id);
                return newJob;
            }
            return job;
        }).toList();
        return flag.get();
    }

    @Override
    public boolean deleteJob(@NotNull Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }
}

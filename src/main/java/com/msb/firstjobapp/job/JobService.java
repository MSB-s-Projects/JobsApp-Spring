package com.msb.firstjobapp.job;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<Job> findAll();

    Optional<Job> findJobById(@NotNull Long id);

    void createJob(@NotNull Job job);

    boolean updateJob(@NotNull Long id,@NotNull Job newJob);

    boolean deleteJob(@NotNull Long id);
}

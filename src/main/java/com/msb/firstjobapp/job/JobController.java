package com.msb.firstjobapp.job;

import com.msb.firstjobapp.utils.Response;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {
    private static final Logger log = LoggerFactory.getLogger(JobController.class);
    private final JobService jobService;

    @GetMapping
    public Response<List<Job>> findAll() {
        return new Response<>(HttpStatus.OK, "All Jobs Fetched Successfully", jobService.findAll());
    }

    @GetMapping("/{id}")
    public Response<Job> findJobById(@PathVariable Long id) {
        return jobService.findJobById(id)
                .map(value -> new Response<>(HttpStatus.OK, "Job Found Successfully", value))
                .orElseGet(() -> {
                    log.info("Job with id {} Not found", id);
                    return new Response<>(HttpStatus.NOT_FOUND, "No Job Found with id " + id, null);
                });
    }

    @PostMapping
    public Response<Job> createJob(@RequestBody @NotNull @Valid Job job) {
        jobService.createJob(job);
        return new Response<>(HttpStatus.CREATED, "New job created successfully", job);
    }

    @PutMapping("/{id}")
    public Response<Job> updateJob(@PathVariable Long id, @RequestBody @Valid Job newJob) {
        if (jobService.updateJob(id, newJob)) {
            return new Response<>(HttpStatus.OK, "Job updated successfully", newJob);
        }
        return new Response<>(HttpStatus.NOT_FOUND, "Job with id " + id + " Not Found", null);
    }

    @DeleteMapping("/{id}")
    public Response<Job> deleteJob(@PathVariable Long id) {
        Job job = jobService.findJobById(id).orElse(null);
        if (jobService.deleteJob(id)) return new Response<>(HttpStatus.OK, "Job deleted successfully", job);
        return new Response<>(HttpStatus.NOT_FOUND, "Job with id " + id + " Not Found", null);
    }
}

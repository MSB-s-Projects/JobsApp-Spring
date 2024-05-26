package com.msb.firstjobapp.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Job {
    private Long id;
    private String title;
    private String minSalary;
    private String maxSalary;
    private String location;
}

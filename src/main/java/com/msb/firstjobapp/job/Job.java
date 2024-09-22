package com.msb.firstjobapp.job;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
@Validated
@NoArgsConstructor
@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2)
    private String title;
    @NotBlank
    private String minSalary;
    @NotBlank
    private String maxSalary;
    @NotBlank
    private String location;
}

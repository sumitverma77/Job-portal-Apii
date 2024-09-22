package com.security.job.controller;

import com.security.job.Resoonse.AddJobResponse;
import com.security.job.request.AddJobRequest;
import com.security.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("job/")
public class JobController {
    @Autowired
    JobService jobService;
    @PostMapping("post/")
    public ResponseEntity<AddJobResponse> add(@RequestBody AddJobRequest addRequest) {
        return jobService.saveJob(addRequest);
    }
    }


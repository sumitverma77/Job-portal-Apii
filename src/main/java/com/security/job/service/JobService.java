package com.security.job.service;

import com.security.job.DTOConverter.DTOConverter;
import com.security.job.Resoonse.AddJobResponse;
import com.security.job.repo.JobPostDAO;
import com.security.job.request.AddJobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobPostDAO jobPostDAO;

    public ResponseEntity<AddJobResponse> saveJob(AddJobRequest addJobRequest) {
        jobPostDAO.save(DTOConverter.ConvertAddJobRequestToJobEntity(addJobRequest));
        return new ResponseEntity<>(new AddJobResponse("Job saved successfully"), HttpStatus.OK);
    }
}

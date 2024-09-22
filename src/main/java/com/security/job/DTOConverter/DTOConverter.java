package com.security.job.DTOConverter;

import com.security.job.entity.JobEntity;
import com.security.job.request.AddJobRequest;

public class DTOConverter {
  public static JobEntity ConvertAddJobRequestToJobEntity(AddJobRequest addJobRequest)
  {
    JobEntity jobEntity = new JobEntity();
    jobEntity.setJobTitle(addJobRequest.getJobTitle());
    jobEntity.setDescription(addJobRequest.getDescription());
    jobEntity.setExperience(addJobRequest.getExperience());
    jobEntity.setApplicationOpenTill(addJobRequest.getApplicationOpenTill());
    jobEntity.setDateOfRelease(addJobRequest.getDateOfRelease());
    return  jobEntity;
  }

}

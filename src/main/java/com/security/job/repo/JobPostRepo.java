package com.security.job.repo;

import com.security.job.entity.JobEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@EnableScan
@Repository
public interface JobPostRepo extends CrudRepository<JobEntity, String> {
}

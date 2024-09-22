package com.security.job.repo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.security.job.entity.JobEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobPostDAO extends AbstractDynamoDBDAO<JobEntity> {

    @Autowired
    public JobPostDAO(DynamoDBMapper dynamoDBMapper) {
        super(dynamoDBMapper);
    }

    public JobEntity getJobPost(String id) {
        return getDynamoDBMapper().load(JobEntity.class, id);
    }

    public void update(JobEntity entity) {
        getDynamoDBMapper()
            .save(entity, DynamoDBMapperConfig.builder().withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE).build());
    }

    public void save(JobEntity entity) {
        getDynamoDBMapper().save(entity);
    }
}

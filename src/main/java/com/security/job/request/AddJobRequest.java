package com.security.job.request;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.Data;

@Data
public class AddJobRequest {

    private String jobTitle;

    private String description;

    private String applicationLink;

    private String dateOfRelease;

    private String applicationOpenTill;

    private String experience;
}

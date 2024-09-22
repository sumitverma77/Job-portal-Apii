package com.security.job.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.security.job.config.dto.aws.DynamoDBConfigDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfiguration {
    private final DynamoDBConfigDto config;
    public DynamoDBConfiguration(DynamoDBConfigDto config) {
        this.config = config;
    }
    @Bean
    public DynamoDBMapper amazonDynamoDB() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder
            .standard()
            .withRegion(Regions.fromName(config.getRegion()))
            .withClientConfiguration(clientConfiguration)
            .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
            .build();

        return new DynamoDBMapper(amazonDynamoDB);
    }
}

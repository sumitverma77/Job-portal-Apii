package com.security.job.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.security.job.config.dto.aws.DynamoDBConfigDto;
import lombok.Data;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Data
@Configuration
@Scope("prototype")
public class DynamoDBConfiguration {
    private final DynamoDBConfigDto config;
    public DynamoDBConfiguration(DynamoDBConfigDto config) {
        this.config = config;
    }
    @Bean
    public DynamoDBMapper amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBAsyncClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(config.getEndpoint(),  config.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(config.getAccessKey(), config.getSecret())))
                .build();
/*
Can use the second method also for AWS we do not neet to pass endpoint & credentials
 */
    //        ClientConfiguration clientConfiguration = new ClientConfiguration();
    //        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder
    //            .standard()
    //            .withRegion(Regions.fromName(config.getRegion()))
    //            .withClientConfiguration(clientConfiguration)
    //            .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
    //            .build();
        return new DynamoDBMapper(amazonDynamoDB);
    }
}

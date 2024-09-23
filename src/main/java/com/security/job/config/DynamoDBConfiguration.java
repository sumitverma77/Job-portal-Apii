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
        String accessKeyId = System.getenv("AMAZON_AWS_ACCESSKEY");
        String secretAccessKey = System.getenv("AMAZON_AWS_SECRETKEY");
        String region = System.getenv("AMZON_DYNAMODB_REGION");
        String endpoint = System.getenv("AMAZON_DYNAMODB_URL");
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBAsyncClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(endpoint,  region))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(secretAccessKey, accessKeyId)))
                .build();
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

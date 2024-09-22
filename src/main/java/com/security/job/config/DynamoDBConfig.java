package com.security.job.config;

//@Configuration
//@EnableDynamoDBRepositories(basePackages = "com.security.job.repo")
public class DynamoDBConfig {
//
//    @Bean
//    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
//        return new DynamoDBMapper(amazonDynamoDB);
//    }
//
//    @Value("${AMAZON_DYNAMODB_URL}")
//    private String amazonDynamoDBEndpoint;
//
//    @Value("${AMAZON_AWS_ACCESSKEY}")
//    private String amazonAWSAccessKey;
//
//    @Value("${AMAZON_AWS_SECRETKEY}")
//    private String amazonAWSSecretKey;
//
//
//
//    @Bean
//    public AmazonDynamoDB amazonDynamoDB() {
//        return AmazonDynamoDBAsyncClientBuilder
//                .standard()
//                .withEndpointConfiguration(
//                        new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint,  "fakeRegion"))
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey)))
//                .build();
//    }
}

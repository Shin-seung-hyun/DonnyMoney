package com.web.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	
    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKeyId;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretAccessKey;
    
    @Value("${cloud.aws.region.static}")
    private String region;
    
    @Bean
    public AmazonS3Client amazonS3Client(){
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
										                .withRegion(region).enablePathStyleAccess()
										                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
										                .build();
    }
}

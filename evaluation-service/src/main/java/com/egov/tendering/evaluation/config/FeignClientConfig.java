package com.egov.tendering.evaluation.config;


import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Configuration for Feign clients
 */
@Configuration
@Slf4j
public class FeignClientConfig {

    /**
     * Configure logging level for Feign clients
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * Configure timeout settings for Feign clients
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(
                10, TimeUnit.SECONDS,
                60, TimeUnit.SECONDS,
                true
        );
    }

    /**
     * Configure retry settings for Feign clients
     */
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(
                100, // initial backoff in ms
                TimeUnit.SECONDS.toMillis(1), // max backoff in ms
                3 // max attempts
        );
    }

    /**
     * Custom error decoder for Feign clients
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            log.error("Feign client error: {} {} - status {}",
                    response.request().httpMethod(),
                    response.request().url(),
                    response.status());

            return feign.FeignException.errorStatus(methodKey, response);
        };
    }
}
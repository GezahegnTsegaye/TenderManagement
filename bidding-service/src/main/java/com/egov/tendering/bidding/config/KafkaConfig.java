package com.egov.tendering.bidding.config;


import com.egov.tendering.bidding.event.BidEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Value("${app.kafka.topics.bid-events}")
    private String bidEventsTopic;

    @Bean
    public NewTopic bidEventsTopic() {
        return TopicBuilder
                .name(bidEventsTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public KafkaTemplate<String, BidEvent> kafkaTemplate(ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>((ProducerFactory<String, BidEvent>) (Object) producerFactory);
    }
}
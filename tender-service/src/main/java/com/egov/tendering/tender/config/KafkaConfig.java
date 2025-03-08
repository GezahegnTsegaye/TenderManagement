package com.egov.tendering.tender.config;


import com.egov.tendering.tender.event.TenderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Value("${app.kafka.topics.tender-events}")
    private String tenderEventsTopic;

    @Bean
    public NewTopic tenderEventsTopic() {
        return TopicBuilder
                .name(tenderEventsTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public KafkaTemplate<String, TenderEvent> kafkaTemplate(ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>((ProducerFactory<String, TenderEvent>) (Object) producerFactory);
    }
}

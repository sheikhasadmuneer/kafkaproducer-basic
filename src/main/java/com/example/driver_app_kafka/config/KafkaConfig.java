package com.example.driver_app_kafka.config;

import com.example.driver_app_kafka.constant.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {



    // crete topic
    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(AppConstants.CAP_LOCATION)
//                .partitions(3)
//                .replicas(3)
                .build();

    }
}

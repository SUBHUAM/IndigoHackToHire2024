package com.userConsumer.userConsumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.userConsumer.userConsumer.constants.KafkaConstants;
import com.userConsumer.userConsumer.dto.FlightDetailsDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.ast.TypeReference;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Bean
    public ConsumerFactory<String, FlightDetailsDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        JsonDeserializer<FlightDetailsDto> deserializer = new JsonDeserializer<>(FlightDetailsDto.class, false);
        deserializer.addTrustedPackages("*");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.kafka_broker);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,KafkaConstants.group_id);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }
    @Bean
    public   ConcurrentKafkaListenerContainerFactory<String,FlightDetailsDto> kafkaListenerContainerFactory(ConsumerFactory<String,FlightDetailsDto> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, FlightDetailsDto> kafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return kafkaListenerContainerFactory;
    }
}

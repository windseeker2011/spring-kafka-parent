package com.ephonetech.spring.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.ephonetech.spring.kafka.partition.MyPartition;

/**
 * 自定义kafka生产者参数
 * 
 * @author Weihai Li
 *
 */
@Configuration
public class KafkaProducerConfiguration {

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		System.out.println("KafkaProducerConfiguration.kafkaTemplate()");
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		System.out.println("KafkaProducerConfiguration.producerFactory()");
		return new DefaultKafkaProducerFactory<>(configs());
	}

	@Bean
	public Map<String, Object> configs() {
		System.out.println("KafkaProducerConfiguration.configs()");
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyPartition.class);
		return props;
	}
}

package com.ephonetech.spring.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者（方法级注解）
 * 
 * @author Weihai Li
 *
 */
@Component
public class KafkaConsumerInMethod {

	@KafkaListener(id = "tt", topics = "kafka")
	public void listen(ConsumerRecord<String, String> cr) {
		System.out.println("KafkaListener in method>>> " + cr.value());
	}

}

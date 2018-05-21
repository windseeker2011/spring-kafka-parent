package com.ephonetech.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者2
 * 
 * @author Weihai Li
 *
 */
@Component
public class KafkaConsumer2 {

	@KafkaListener(id = "c2", groupId = "group1", topics = "logs")
	public void listen(ConsumerRecord<String, String> cr) {
		System.out.println("KafkaListener 2>>> " + cr);
	}

}

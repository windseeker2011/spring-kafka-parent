package com.ephonetech.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者3
 * 
 * @author Weihai Li
 *
 */
@Component
public class KafkaConsumer3 {

	@KafkaListener(id = "c3", groupId = "group1", topics = "logs")
	public void listen(ConsumerRecord<String, String> cr) {
		System.out.println("KafkaListener 3>>> " + cr);
	}

}

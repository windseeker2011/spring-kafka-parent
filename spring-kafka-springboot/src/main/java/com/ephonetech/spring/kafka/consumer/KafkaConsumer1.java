package com.ephonetech.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者1
 * 
 * @author Weihai Li
 *
 */
@Component
public class KafkaConsumer1 {

	@KafkaListener(id = "c1", groupId = "group", topics = "logs")
	public void listen(ConsumerRecord<String, String> cr) {
		System.out.println("KafkaListener 1>>> " + cr);
	}

}

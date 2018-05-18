package com.ephonetech.spring.kafka.controller;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * 消费者
 * 
 * @author Weihai Li
 *
 */
@KafkaListener(id = "tt", topics = "kafka")
public class KafkaConsumer {

	@KafkaHandler
	public void handleString(String foo) {
		System.out.println("KafkaConsumer.handleString() " + foo);
	}

	@KafkaHandler
	public void handleInteger(Integer bar) {
		System.out.println("KafkaConsumer.handleInteger() " + bar);
	}

	@KafkaHandler(isDefault = true)
	public void handleOject(Object obj) {
		System.out.println("KafkaConsumer.handleOject() " + obj);
	}

}

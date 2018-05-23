package com.ephonetech.spring.kafka.stream.a.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 生产（Source）
 * 
 * @author Weihai Li
 *
 */
@EnableBinding(Source.class)
public class SimpleProducer {

	@Autowired
	private Source source;

	public void sendMessage(String payload) {
		this.source.output().send(MessageBuilder.withPayload(payload).build());
	}

}

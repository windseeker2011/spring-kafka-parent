package com.ephonetech.spring.kafka.stream.b.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 生产（使用 {@link MySource}）
 * 
 * @author Weihai Li
 *
 */
@EnableBinding(MySource.class)
public class MyProducer {

	@Autowired
	private MySource source;

	public void sendMessage(String payload) {
		this.source.output().send(MessageBuilder.withPayload(payload).build());
	}

}
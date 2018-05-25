package com.ephonetech.spring.kafka.stream.c.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import com.ephonetech.spring.kafka.stream.c.MyMessage;

/**
 * 生产（使用 {@link TestSource}）
 * 
 * @author Weihai Li
 *
 */
@EnableBinding(TestSource.class)
public class TestProducer {

	@Autowired
	private TestSource source;

	public void sendMessage(MyMessage payload) {
		this.source.output().send(MessageBuilder.withPayload(payload).build());
	}

}
package com.ephonetech.spring.kafka.stream.a.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 消费（Sink）
 * 
 * @author Weihai Li
 *
 */
@EnableBinding(Sink.class)
public class SimpleConsumer {

	@StreamListener(Sink.INPUT)
	public void process(String playload) {
		System.out.println("Received:" + playload);
	}

}
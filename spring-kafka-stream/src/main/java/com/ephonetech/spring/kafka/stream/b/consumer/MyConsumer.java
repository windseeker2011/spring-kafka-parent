package com.ephonetech.spring.kafka.stream.b.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消费（使用 {@link MySink}）
 * 
 * @author Weihai Li
 *
 */
@EnableBinding(MySink.class)
public class MyConsumer {

	@StreamListener(MySink.INPUT)
	public void process(String playload) {
		System.out.println("Received:" + playload);
	}

}
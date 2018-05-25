package com.ephonetech.spring.kafka.stream.c.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.ephonetech.spring.kafka.stream.c.MyMessage;

/**
 * 消费（使用 {@link Sink}）
 * 
 * @author Weihai Li
 *
 */
@EnableBinding(TestSink.class)
public class TestConsumer {

	@Value("${task}")
	private int index;// 任务序号

	@StreamListener(TestSink.INPUT)
	public void process(MyMessage playload) {
		System.out.println("Received" + index + ":" + playload);
	}

}
package com.ephonetech.spring.kafka.stream.c.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义管道输入（参考 {@link Sink}）
 * 
 * @author Weihai Li
 *
 */
public interface TestSink {

	String INPUT = "mychannel";

	@Input(TestSink.INPUT)
	SubscribableChannel input();

}

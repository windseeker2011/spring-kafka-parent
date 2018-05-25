package com.ephonetech.spring.kafka.stream.c.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义管道输出（参考 {@link Source}）
 * 
 * @author Weihai Li
 *
 */
public interface TestSource {

	String OUTPUT = "mychannel";

	@Output(TestSource.OUTPUT)
	MessageChannel output();

}

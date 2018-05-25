package com.ephonetech.spring.kafka.stream.c.producer;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ephonetech.spring.kafka.stream.c.MyMessage;

/**
 * 自动任务
 * 
 * @author Weihai Li
 *
 */
@Component
public class SendTask {

	@Autowired
	private TestProducer producer;

	private AtomicInteger ai = new AtomicInteger(0);

	@Value("${task}")
	private int index;// 任务序号

	/**
	 * 每6秒产生10条数据
	 */
	@Scheduled(fixedDelay = 6000)
	public void sendMessage() {
		for (int j = 0; j < 10; j++) {
			// 下发消息
			MyMessage message = new MyMessage();
			message.setId(index);
			message.setMsg("message" + index + "_" + ai.getAndIncrement());
			producer.sendMessage(message);
		}
	}

}

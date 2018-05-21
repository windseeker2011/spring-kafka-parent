package com.ephonetech.spring.kafka.producer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 自动生产者
 * 
 * @author Weihai Li
 *
 */
@Component
public class KakfaAutoProducer {

	@Autowired
	private KafkaTemplate<String, String> template;

	private static String TOPIC = "logs";

	private Executor executor = Executors.newCachedThreadPool();

	private AtomicInteger ai = new AtomicInteger(0);

	@Bean
	public String autoSendMessage() {
		for (int i = 0; i < 10; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						// 下发消息
						template.send(TOPIC, String.valueOf(j), "message" + ai.getAndIncrement())
								.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
									@Override
									public void onSuccess(SendResult<String, String> result) {
										// System.out.println("成功 " + result);

									}

									@Override
									public void onFailure(Throwable ex) {
										// System.out.println("失败 " +
										// ex.getMessage());

									}

								});
					}
				}
			});
		}
		return "success";
	}

}

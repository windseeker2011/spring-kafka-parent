package com.ephonetech.spring.kafka.demo.chapter4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 发送成功或失败处理（异步）
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
@EnableKafka
public class Chapter4_async implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Chapter4_async.class, args).close();
	}

	@Autowired
	private KafkaTemplate<Integer, String> template;

	@Override
	public void run(String... args) throws Exception {
		ListenableFuture<SendResult<Integer, String>> future = this.template.send("topic4", "haha");
		future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				System.out.println("下发成功 " + result);

			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("下发成功失败 " + ex.getMessage());

			}

		});
	}

}

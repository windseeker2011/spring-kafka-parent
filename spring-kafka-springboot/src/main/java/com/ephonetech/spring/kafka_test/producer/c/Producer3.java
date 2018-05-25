package com.ephonetech.spring.kafka_test.producer.c;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 生产者1号
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
@EnableKafka
@EnableScheduling
public class Producer3 {

	@Value("${topic}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, String> template;

	private AtomicInteger ai = new AtomicInteger(0);

	/**
	 * 每6秒产生10条数据
	 */
	@Scheduled(fixedRate = 6000, initialDelay = 4000)
	public void produce() {
		for (int j = 0; j < 10; j++) {
			// 下发消息
			template.send(topic, "2", "message2_" + ai.getAndIncrement())
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

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--spring.profiles.active=p3" };
		SpringApplication.run(Producer3.class, args2);
	}

}

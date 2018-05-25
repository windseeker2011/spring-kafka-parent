package com.ephonetech.spring.kafka_test.consumer.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * 消费者1号
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class Consumer1 {

	@KafkaListener(id = "1", topics = "${topic}", groupId = "group1")
	public void listen(String msg) {
		System.out.println("1 收到： " + msg);
	}

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--spring.profiles.active=c1" };
		SpringApplication.run(Consumer1.class, args2);
	}

}

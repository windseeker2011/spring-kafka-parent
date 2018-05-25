package com.ephonetech.spring.kafka_test.consumer.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * 消费者3号
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class Consumer3 {

	@KafkaListener(id = "3", topics = "${topic}", groupId = "group1")
	public void listen(String msg) {
		System.out.println("3 收到： " + msg);
	}

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--spring.profiles.active=c3" };
		SpringApplication.run(Consumer3.class, args2);
	}

}

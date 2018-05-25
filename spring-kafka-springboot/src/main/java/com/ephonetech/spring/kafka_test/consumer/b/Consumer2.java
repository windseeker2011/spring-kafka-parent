package com.ephonetech.spring.kafka_test.consumer.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * 消费者2号
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class Consumer2 {

	@KafkaListener(id = "2", topics = "${topic}", groupId = "group1")
	public void listen(String msg) {
		System.out.println("2 收到： " + msg);
	}

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--spring.profiles.active=c2" };
		SpringApplication.run(Consumer2.class, args2);
	}

}

package com.ephonetech.spring.kafka_test.consumer.others;

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
public class Consumer4 {

	@KafkaListener(id = "4", topics = "${topic}", groupId = "group")
	public void listen(String msg) {
		System.out.println("4 in other group 收到： " + msg);
	}

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--spring.profiles.active=co" };
		SpringApplication.run(Consumer4.class, args2);
	}

}

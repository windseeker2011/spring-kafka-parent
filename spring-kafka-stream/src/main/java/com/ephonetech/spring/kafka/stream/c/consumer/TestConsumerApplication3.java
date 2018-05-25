package com.ephonetech.spring.kafka.stream.c.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者3
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class TestConsumerApplication3 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8883", "--spring.profiles.active=tin3", "--task=3" };
		SpringApplication.run(TestConsumerApplication3.class, args2);
	}

}

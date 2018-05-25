package com.ephonetech.spring.kafka.stream.c.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者2
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class TestConsumerApplication2 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8882", "--spring.profiles.active=tin2", "--task=2" };
		SpringApplication.run(TestConsumerApplication2.class, args2);
	}

}

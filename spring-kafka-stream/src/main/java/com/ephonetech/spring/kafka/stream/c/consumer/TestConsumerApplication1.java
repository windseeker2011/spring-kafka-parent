package com.ephonetech.spring.kafka.stream.c.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者1
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class TestConsumerApplication1 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8881", "--spring.profiles.active=tin1", "--task=1" };
		SpringApplication.run(TestConsumerApplication1.class, args2);
	}

}

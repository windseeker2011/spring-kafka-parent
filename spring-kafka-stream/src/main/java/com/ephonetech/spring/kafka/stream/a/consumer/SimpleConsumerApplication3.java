package com.ephonetech.spring.kafka.stream.a.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者3
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class SimpleConsumerApplication3 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8883", "--spring.profiles.active=sin3" };
		SpringApplication.run(SimpleConsumerApplication3.class, args2);
	}

}

package com.ephonetech.spring.kafka.stream.a.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者2
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class SimpleConsumerApplication2 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8882", "--spring.profiles.active=sin2" };
		SpringApplication.run(SimpleConsumerApplication2.class, args2);
	}

}

package com.ephonetech.spring.kafka.stream.a.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者1
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class SimpleConsumerApplication1 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8881", "--spring.profiles.active=sin1" };
		SpringApplication.run(SimpleConsumerApplication1.class, args2);
	}

}

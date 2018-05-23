package com.ephonetech.spring.kafka.stream.b.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者1
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class MyConsumerApplication1 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8891", "--spring.profiles.active=myin1" };
		SpringApplication.run(MyConsumerApplication1.class, args2);
	}

}

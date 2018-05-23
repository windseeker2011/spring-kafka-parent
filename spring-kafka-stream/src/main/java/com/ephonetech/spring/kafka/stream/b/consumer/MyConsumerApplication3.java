package com.ephonetech.spring.kafka.stream.b.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者3
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class MyConsumerApplication3 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8893", "--spring.profiles.active=myin3" };
		SpringApplication.run(MyConsumerApplication3.class, args2);
	}

}

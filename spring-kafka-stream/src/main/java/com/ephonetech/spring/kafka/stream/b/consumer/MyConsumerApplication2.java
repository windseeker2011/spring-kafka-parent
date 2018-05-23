package com.ephonetech.spring.kafka.stream.b.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者2
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
public class MyConsumerApplication2 {

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8892", "--spring.profiles.active=myin2" };
		SpringApplication.run(MyConsumerApplication2.class, args2);
	}

}

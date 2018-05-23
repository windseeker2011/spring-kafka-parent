package com.ephonetech.spring.kafka.stream.b.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义版生产者
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
@RestController
public class MyProducerApplication {

	@Autowired
	private MyProducer producer;

	@GetMapping(value = "/{msg}")
	public String sendMessage(@PathVariable String msg) {
		producer.sendMessage(msg);
		return "ok";
	}

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8890", "--spring.profiles.active=myout" };
		SpringApplication.run(MyProducerApplication.class, args2);
	}

}

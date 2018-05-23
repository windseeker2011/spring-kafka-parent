package com.ephonetech.spring.kafka.stream.a.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 简易版生产者
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
@RestController
public class SimpleProducerApplication {

	@Autowired
	private SimpleProducer producer;

	@GetMapping(value = "/{msg}")
	public String sendMessage(@PathVariable String msg) {
		producer.sendMessage(msg);
		return "ok";
	}

	public static void main(String[] args) throws Exception {
		String[] args2 = new String[] { "--server.port=8890", "--spring.profiles.active=sout" };
		SpringApplication.run(SimpleProducerApplication.class, args2);
	}

}

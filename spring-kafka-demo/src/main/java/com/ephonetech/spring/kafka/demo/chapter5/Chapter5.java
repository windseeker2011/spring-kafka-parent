package com.ephonetech.spring.kafka.demo.chapter5;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class Chapter5 implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Chapter5.class, args);
	}

	@Autowired
	private KafkaTemplate<String, String> template;

	@Override
	public void run(String... args) throws Exception {
		this.template.executeInTransaction(t -> {
			t.send("topic5", "haha");
			return true;
		});

	}

	@Bean
	public NewTopic topic() {
		return new NewTopic("topic5", 10, (short) 2);
	}

}

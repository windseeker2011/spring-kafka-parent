package com.ephonetech.spring.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringKafkaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringKafkaApplication.class, args);

	}

}

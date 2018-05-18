package com.ephonetech.spring.kafka.demo.chapter3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Chapter3 implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Chapter3.class, args).close();
	}

	@Autowired
	private KafkaTemplate<Integer, String> template;

	private final CountDownLatch latch = new CountDownLatch(3);

	@Override
	public void run(String... args) throws Exception {
		this.template.send("topic1", "haha");
		this.template.send("topic1", "hehe");
		this.template.send("topic1", "xixi");
		latch.await(60, TimeUnit.SECONDS);
		System.out.println("处理完毕");
	}

	@KafkaListener(topics = "topic1")
	public void listen(ConsumerRecord<Integer, String> cr) {
		System.out.println(">>>" + cr.toString());
		latch.countDown();
	}

}

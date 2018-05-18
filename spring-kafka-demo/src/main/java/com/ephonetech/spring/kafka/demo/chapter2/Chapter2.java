package com.ephonetech.spring.kafka.demo.chapter2;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring Kafka入门章节2 - 配置版
 * 
 * @author Weihai Li
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Chapter2.class)
@SpringBootApplication
public class Chapter2 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Chapter2.class, args);
	}

	@Autowired
	private Listener listener;

	@Autowired
	private KafkaTemplate<Integer, String> template;

	@Test
	public void testSimple() throws Exception {
		template.send("annotated1", 0, "haha");
		template.flush();
		this.listener.latch1.await(10, TimeUnit.SECONDS);
	}

}

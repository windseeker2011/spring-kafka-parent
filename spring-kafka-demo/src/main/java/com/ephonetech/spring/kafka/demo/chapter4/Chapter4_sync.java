package com.ephonetech.spring.kafka.demo.chapter4;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

/**
 * 发送成功或失败处理（同步）
 * 
 * @author Weihai Li
 *
 */
@SpringBootApplication
@EnableKafka
public class Chapter4_sync implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Chapter4_sync.class, args).close();
	}

	@Autowired
	private KafkaTemplate<Integer, String> template;

	@Override
	public void run(String... args) throws Exception {
		try {
			SendResult<Integer, String> sendResult = this.template.send("topic4", "haha").get(10, TimeUnit.SECONDS);

			System.out.println("下发成功 " + sendResult);
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("下发失败 " + e.getMessage());
		}

	}

}

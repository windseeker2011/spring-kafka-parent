package com.ephonetech.spring.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ephonetech.spring.kafka.dto.Message;
import com.google.gson.GsonBuilder;

/**
 * 生产者
 * 
 * @author Weihai Li
 *
 */
@RestController
@RequestMapping(value = "/")
public class KakfaProducer {

	@Autowired
	private KafkaTemplate<String, String> template;

	private static String TOPIC = "kafka";

	@PostMapping(value = "string")
	public String sendMessage(@RequestParam String message) {
		template.send(TOPIC, "1", message);
		return "success";
	}

	@PostMapping(value = "integer")
	public String sendMessage(@RequestParam Integer message) {
		template.send(TOPIC, "2", String.valueOf(message));
		return "success";
	}

	@PostMapping(value = "object")
	public String sendMessage(@RequestBody Message message) {
		GsonBuilder gb = new GsonBuilder();
		gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
		template.send(TOPIC, "3", gb.create().toJson(message));
		return "success";
	}

}

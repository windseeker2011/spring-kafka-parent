package com.ephonetech.spring.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
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

	private static String TOPIC = "logs";

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
		template.send(TOPIC, "3", gb.create().toJson(message))
				.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
					@Override
					public void onSuccess(SendResult<String, String> result) {
						System.out.println("成功 " + result);

					}

					@Override
					public void onFailure(Throwable ex) {
						System.out.println("失败 " + ex.getMessage());

					}

				});
		return "success";
	}

}

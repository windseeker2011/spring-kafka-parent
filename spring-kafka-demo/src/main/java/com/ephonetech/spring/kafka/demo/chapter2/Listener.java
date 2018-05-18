package com.ephonetech.spring.kafka.demo.chapter2;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
	
	final CountDownLatch latch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "annotated1")
    public void listen1(String foo) {
    	System.out.println(">>> " + foo);
        this.latch1.countDown();
    }
}

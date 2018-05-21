package com.ephonetech.spring.kafka.demo.chapter1;

import java.util.Map;
import java.util.Random;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

/**
 * 用来测试的一个分区规则
 * 
 * @author Weihai Li
 *
 */
public class MyPartition implements Partitioner {

	@Override
	public void configure(Map<String, ?> configs) {
		System.out.println("MyPartition.configure()");

	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		// 自定义分区规则，与key一一致
		int p = 0;
		if (key != null) {
			p = Integer.parseInt(String.valueOf(key));
		} else {
			p = new Random().nextInt(10);
		}
		return p;
	}

	@Override
	public void close() {
		System.out.println("MyPartition.close()");

	}

}

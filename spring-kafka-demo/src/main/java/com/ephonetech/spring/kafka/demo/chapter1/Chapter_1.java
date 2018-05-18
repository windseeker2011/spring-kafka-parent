package com.ephonetech.spring.kafka.demo.chapter1;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.config.ContainerProperties;

/**
 * Spring Kafka入门章节1 - 普通类版
 * 
 * @author Weihai Li
 *
 */
public class Chapter_1 {

	/**
	 * 测试Kafka发送接收消息
	 * 
	 * @throws Exception
	 */
	public void testAutoCommit() throws Exception {
		System.out.println(" start auto ");
		ContainerProperties cp = new ContainerProperties("topic1", "topic2");
		// 消息监听回调函数
		cp.setMessageListener(new MessageListener<Integer, String>() {
			@Override
			public void onMessage(ConsumerRecord<Integer, String> data) {
				System.out.println("received:" + data);

			}
		});

		KafkaMessageListenerContainer<Integer, String> container = createContainer(cp);
		container.setBeanName("test auto");
		container.start();

		Thread.sleep(1000);
		/*
		 * 生产者代码
		 */
		{
			// 向topic1发送
			KafkaTemplate<Integer, String> template = createTemplate();
			template.setDefaultTopic("topic1");
			template.sendDefault(0, "test0");
			template.sendDefault(1, "test1");
			template.sendDefault(2, "test2");
			template.flush();
			// 向topic2发送
			template.setDefaultTopic("topic2");
			template.sendDefault(0, "haha0");
			template.sendDefault(1, "haha1");
			template.sendDefault(2, "haha2");
			template.flush();
		}

		container.stop();

		System.out.println(" stop auto ");
	}

	/**
	 * Kafka消息发送
	 * 
	 * @return
	 */
	private KafkaTemplate<Integer, String> createTemplate() {

		Map<String, Object> configs = producerConfigs();

		ProducerFactory<Integer, String> producerFactory = new DefaultKafkaProducerFactory<>(configs);

		KafkaTemplate<Integer, String> template = new KafkaTemplate<>(producerFactory);

		return template;
	}

	/**
	 * 生产者配置
	 * 
	 * @return
	 */
	private Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}

	/**
	 * kafka消息处理
	 * 
	 * @param cp
	 * @return
	 */
	private KafkaMessageListenerContainer<Integer, String> createContainer(ContainerProperties cp) {

		Map<String, Object> configs = consumerConfigs();

		ConsumerFactory<Integer, String> consumerFactory = new DefaultKafkaConsumerFactory<>(configs);

		KafkaMessageListenerContainer<Integer, String> container = new KafkaMessageListenerContainer<>(consumerFactory,
				cp);

		return container;
	}

	/**
	 * 消费者配置
	 * 
	 * @return
	 */
	private Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return props;
	}

	public static void main(String[] args) throws Exception {
		new Chapter_1().testAutoCommit();
	}
}

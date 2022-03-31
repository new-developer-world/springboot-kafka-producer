package com.poc.springboot.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.poc.springboot.constant.ApplicationConstant;
import com.poc.springboot.entity.Book;

@Configuration
public class SpringKafkaConfiguration {
	
	@Bean
	public ProducerFactory<String, Book> producerBookFactory(){
		Map<String, Object> config=new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationConstant.KAFKA_LOCAL_SERVER_CONFIG);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);
		
	}
	
	@Bean
	public KafkaTemplate<String, Book> kafkaBookTemplate(){
		return new KafkaTemplate<>(producerBookFactory());
	}
	
	@Bean
	public ProducerFactory<String, String> producerFactor(){
		Map<String, Object> config=new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationConstant.KAFKA_LOCAL_SERVER_CONFIG);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);
		
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactor());
	}

	
}

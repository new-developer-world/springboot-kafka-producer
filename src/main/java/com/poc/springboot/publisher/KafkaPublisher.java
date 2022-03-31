package com.poc.springboot.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.springboot.constant.ApplicationConstant;
import com.poc.springboot.entity.Book;

@RestController
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, Book> template;
	
	@Autowired
	private KafkaTemplate<String, String> template1;
	@PostMapping("/publish")
	public String createPublish(@RequestBody Book book) {
		template.send(ApplicationConstant.TOPIC_NAME,book);
		
		return "Successfully Published ...";
	}
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		template1.send(ApplicationConstant.TOPIC_NAME  ,"Hi " + name +" welcome to developer world");
		
		return "Data published!!!!";
	}
	

}
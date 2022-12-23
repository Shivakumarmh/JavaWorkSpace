package com.dk.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dk.springboot.service.Producer;

@SpringBootApplication
@RestController
public class KaftaSpringBootApplication {
	
	@Autowired
	Producer producer;
	
	@GetMapping("publish/{name}")
	public void publishMessage(@PathVariable String name)
	{
		producer.sendMessage(name);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(KaftaSpringBootApplication.class, args);
	}

}

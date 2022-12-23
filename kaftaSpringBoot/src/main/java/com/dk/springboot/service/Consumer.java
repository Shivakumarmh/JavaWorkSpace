package com.dk.springboot.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics = "testtopic1", groupId = "testgroupid1")
	public void listenToMessage(String message)
	{
		System.out.println("Message is " + message);
	}
}

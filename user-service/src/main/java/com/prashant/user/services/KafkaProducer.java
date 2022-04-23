package com.prashant.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class KafkaProducer {
	 @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;
	    private static final String TOPIC = "users";
	    
	     
		    public void pushToKafka(String message)   {
		        this.kafkaTemplate.send(TOPIC, message);

		    }
}

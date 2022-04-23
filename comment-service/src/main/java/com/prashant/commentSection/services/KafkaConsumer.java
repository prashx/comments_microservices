package com.prashant.commentSection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class KafkaConsumer {
	 @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

		@Autowired
		private JwtUserService jwtUserDetailsService;
		
	    private static final String TOPIC = "users";
	    
	     
		   @KafkaListener(topics = "users", groupId = "group_id")
		    public void consume(String message)   {
			  int pwdIndex=message.indexOf(":");
			  jwtUserDetailsService.addUserDetails(message.substring(0, pwdIndex), message.substring(pwdIndex+1));
		    }
}

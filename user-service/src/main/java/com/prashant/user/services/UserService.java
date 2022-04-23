package com.prashant.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.prashant.user.UserDAO;
import com.prashant.user.domain.User;

@Service
@Configuration
@Component
public class UserService  {
	@Autowired
	UserDAO userDAO;
	@Autowired
	KafkaProducer producer;
	private PasswordEncoder bcryptEncoder=new BCryptPasswordEncoder();
	
	public User save(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDAO.save(user);
	}

	
	public User getUser(Long userId) {
		return userDAO.getById(userId);
	}

	
	public List<User> getUsers() {
		return userDAO.findAll();
	}

	
	public User updateUser(User user)
	{
		return userDAO.save(user);
	}


	 
	 @EventListener(ApplicationReadyEvent.class)
	 public void doSomethingAfterStartup() {
		 for(User user:getUsers())
		 {
			 producer.pushToKafka(user.getName()+":"+user.getPassword());
		 }
	 }

}

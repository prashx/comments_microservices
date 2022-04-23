package com.prashant.commentSection.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.security.core.userdetails.User;
@Service
public class JwtUserService implements UserDetailsService  {

	
	private HashMap <String,String> users= new HashMap<>();
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(users.containsKey(username))
		{
			return new User(username, users.get(username),new ArrayList<>());

		}

	/*	if ("Prashant".equals(username)) {//Use DB and fetch user pwd from DAO insetead of hardcoding
			return new User("Prashant", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",new ArrayList<>());
		}*/ else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public void addUserDetails(String uname,String encruptedPwd)
	{
		users.put(uname, encruptedPwd);
	}

}

package com.prashant.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.user.domain.User;


public interface UserDAO extends JpaRepository<User,Long> 
{

}

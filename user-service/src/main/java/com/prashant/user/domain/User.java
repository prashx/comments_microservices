package com.prashant.user.domain;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name="UserDetails")
public class User
{
@Id	
@GeneratedValue(strategy=GenerationType.SEQUENCE)
Long id;

@Column(nullable=false,updatable=false)
String password;

@Column(nullable=false,updatable=false,unique=true)
String name;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


}

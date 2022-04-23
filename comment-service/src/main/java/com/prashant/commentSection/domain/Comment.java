package com.prashant.commentSection.domain;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
//@Table(name="comments")
@JsonIgnoreProperties(value= {"createdAt","updatedAt"},allowGetters=true)
public class Comment
{
@Id	
@GeneratedValue(strategy=GenerationType.SEQUENCE)
Long id;

@Column(nullable=false,updatable=false,name="content")
String comment;

@Column(nullable=false)
@Temporal(TemporalType.TIMESTAMP)
@CreatedDate
Date createdAt;

@Column(nullable=false)
@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate
Date updatedAt;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}


}

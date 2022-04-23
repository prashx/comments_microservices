package com.prashant.commentSection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CommentSection {

	public static void main(String[] args) {
		SpringApplication.run(CommentSection.class, args);
	}

}

package com.prashant.commentSection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.commentSection.domain.Comment;
import com.prashant.commentSection.services.CommentServiceImpl;

@RestController
public class CommentSectionController {
	
	
	@Autowired
	CommentServiceImpl commentService;
	
	@PostMapping("/comments")
	public Comment addComment(@RequestBody Comment comment)
	{
		return commentService.save(comment);
	}
	
	@GetMapping("/comments/{id}")
	public Comment getComment(@PathVariable(value="id") Long commentId)
	{
		return commentService.getComment(commentId);
	}

	@GetMapping("/comments")
	public List<Comment> getComments()
	{
		return commentService.getComments();
	}
}

package com.prashant.commentSection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.prashant.commentSection.DAO.CommentDAO;
import com.prashant.commentSection.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO commentDAO;
	
	@Override
	public Comment save(Comment comment) {
		return commentDAO.save(comment);
		
	}

	@Override
	public Comment getComment(Long commentId) {
		return commentDAO.getById(commentId);
	}

	@Override
	public List<Comment> getComments() {
		return commentDAO.findAll();
	}

	@Override
	public Comment updateComment(Comment comment)
	{
		return commentDAO.save(comment);
	}



}

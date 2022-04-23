package com.prashant.commentSection.services;

import java.util.List;

import com.prashant.commentSection.domain.Comment;

public interface CommentService {
	
Comment save(Comment comment);

Comment getComment(Long commentId);

List<Comment> getComments();

Comment updateComment(Comment comment);

}

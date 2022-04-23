package com.prashant.commentSection.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.commentSection.domain.Comment;

public interface CommentDAO extends JpaRepository<Comment,Long> 
{

}

package com.codingdojo.loginandregisteration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginandregisteration.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	
}

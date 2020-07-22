package com.iiht.forum.repository;

import java.util.List;



import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iiht.forum.model.VisitorComments;

@Repository
public interface CommentRepository extends MongoRepository<VisitorComments, String>
{
	
}
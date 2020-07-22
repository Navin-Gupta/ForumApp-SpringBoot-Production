package com.iiht.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iiht.forum.model.VisitorPosts;

@Repository
public interface PostRepository extends MongoRepository<VisitorPosts, String>{

	
}
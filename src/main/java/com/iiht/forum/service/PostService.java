package com.iiht.forum.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.model.VisitorPosts;
import com.iiht.forum.repository.PostRepository;

@Service
public class PostService 
{
	@Autowired(required=true)
	private PostRepository repository;

	public Boolean saveUpdate(VisitorPostsDto postInput) 
	{
		return null;
	}
	
	public VisitorPostsDto getPostById(String id)
	{
		return null;
	}
	
	public List<VisitorPostsDto> getAllPosts()
	{
		return null;
	}

	// return authorname and titles of all posts
	public Map<String, String> getDiscussions() {
		return null;
	}
	
}
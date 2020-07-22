package com.iiht.forum.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.service.PostService;

@RestController
public class VisitorPostController {

	@Autowired
	private PostService postService;

	
	
	@PostMapping(value="/savePost")
	public ResponseEntity<Boolean> addPost(@RequestBody VisitorPostsDto visitorPostsDto) {
		return null;
	}
	
	@GetMapping(value = "/getPostById/{id}")
	public ResponseEntity<VisitorPostsDto> getPostById(@PathVariable String id) 
	{
		return null;
	}
	
	@GetMapping(value = "/getAllPosts", produces = "application/json")
	public ResponseEntity<List<VisitorPostsDto>> getAllVisitorPosts() {
		return null;
	}
	
	@GetMapping(value = "/getDiscussionList")
	public ResponseEntity<Map<String, String>> getAllDiscussions() {
		return null;
	}
}
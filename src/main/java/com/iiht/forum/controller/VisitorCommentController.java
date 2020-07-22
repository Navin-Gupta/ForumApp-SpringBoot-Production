package com.iiht.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.service.CommentService;

@RestController
public class VisitorCommentController 
{
	@Autowired
	private CommentService commentService;

	@PostMapping(value="/postComment")
	public ResponseEntity<Boolean> addComment(@RequestBody VisitorCommentsDto visitorCommentsDto)
	{
		return null;
	}
	
	@GetMapping(value = "/getCommentByPostId/{id}")
	public ResponseEntity<List<VisitorCommentsDto>> getCommentsByPostId(@PathVariable String id)
	{
		return null;
	}
}
package com.iiht.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.model.VisitorComments;
import com.iiht.forum.repository.CommentRepository;

@Service
public class CommentService 
{
	@Autowired
	private CommentRepository repository; 

	
	public Boolean saveUpdate(VisitorCommentsDto commentInput)
	{
		return null;
	}
	
	public List<VisitorCommentsDto> getCommentsByPostId(@PathVariable String id)
	{
		return null;
	}
}
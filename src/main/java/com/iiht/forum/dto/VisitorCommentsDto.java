package com.iiht.forum.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorCommentsDto
{
	private String id;

	private String postId;
	
	@NotNull
	@Length(min = 1, max = 50)
	private String authorName;
	

	@NotNull
	@Length(min = 1, max = 50)
	private String tags;
	
	@NotNull
	@Length(min = 1, max = 500)
	private String comment;
	
	
}
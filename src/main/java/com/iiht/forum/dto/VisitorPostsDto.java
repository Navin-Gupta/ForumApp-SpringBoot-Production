package com.iiht.forum.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorPostsDto 
{
	private String id;

	@NotNull
	@Length(min = 1, max = 50)
	private String authorName;
	
	@NotNull
	@Length(min = 1, max = 50)
	private String title;

	@NotNull
	@Length(min = 1, max = 50)
	private String tags;

	@NotNull
	@Length(min = 1, max = 500)
	private String postDescription;


}
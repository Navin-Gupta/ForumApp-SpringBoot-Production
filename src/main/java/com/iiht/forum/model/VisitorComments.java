package com.iiht.forum.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorComments 
{
	@Id
	private String id;
	
	private String authorName;

	private String postId;


	private String tags;
	

	private String comment;

}
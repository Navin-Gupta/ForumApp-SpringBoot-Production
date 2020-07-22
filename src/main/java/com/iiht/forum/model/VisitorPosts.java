package com.iiht.forum.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("postdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorPosts 
{
	@Id
	private String id;
	
	private String authorName;

	private String title;
	

	private String tags;
	

	private String postDescription;
	

}
package com.iiht.forum.UtilTestClass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;

import java.io.IOException;

public class JSONUtils 
{
    public static byte[] toJson(Object object) throws IOException 
    {
        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return mapper.writeValueAsBytes(object);
    }
    
    public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

    public static VisitorPostsDto createPostDto(String id, String authorName, String title, String tags, String postDescription) 
    {
    	VisitorPostsDto posts = new VisitorPostsDto();

    	posts.setId(id);
    	posts.setAuthorName(authorName);
    	posts.setTitle(title);
    	posts.setTags(tags);
    	posts.setPostDescription(postDescription);
  	 	
    	return posts;
    }
    
    public static VisitorCommentsDto createCommentDto(String id, String authorName, String postId, String tags, String postComment) 
    {
    	VisitorCommentsDto comments = new VisitorCommentsDto();

    	comments.setId(id);
    	comments.setAuthorName(authorName);
    	comments.setPostId(postId);
    	comments.setTags(tags);
    	comments.setComment(postComment);
  	 	
    	return comments;
    }
}
package com.iiht.forum.FunctionalTestCases;


import static com.iiht.forum.UtilTestClass.TestUtils.businessTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.CollectionUtils;


import com.iiht.forum.UtilTestClass.JSONUtils;
import com.iiht.forum.controller.VisitorPostController;
import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.service.PostService;



@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(VisitorPostController.class)
public class PostControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PostService service;
	
	//-----------------------------------------------------------------------------
	/*
	 * Description : This test is to perform add new post in the Forum
	 */
	@Test 
	public void testAddPost() throws Exception { 
        VisitorPostsDto visitorPostsDto = JSONUtils.createPostDto("1", "First", "Foot Ball", "Field Game", "#World Sport#Great Sport");
        
        when(this.service.saveUpdate(visitorPostsDto))
		.thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
				.content(JSONUtils.asJsonString(visitorPostsDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	//-----------------------------------------------------------------------------
	/*
	 * Description : This test is to get a particular post
	 */
	@Test 
	public void testGetPostById() throws Exception { 
		VisitorPostsDto visitorPostsDto = JSONUtils.createPostDto("1", "First", "Foot Ball", "Field Game", "#World Sport#Great Sport");
        
        when(this.service.getPostById("1"))
		.thenReturn(visitorPostsDto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPostById/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	  
	//-----------------------------------------------------------------------------
	/*
	 * Description : This test is to perform view all the posts from database
	 */
	@Test 
	public void testGetAllVisitorPosts() throws Exception { 
        // Given input
		VisitorPostsDto post1 = JSONUtils.createPostDto("1", "First", "Kabbadi", "India Sport", "Good Sport. Propularly played by all eastern countries.");
		VisitorPostsDto post2 = JSONUtils.createPostDto("2", "Second", "Ko Ko", "India Sport", "Good Sport. Propularly played by all states in India.");
		VisitorPostsDto post3 = JSONUtils.createPostDto("3", "Third", "Chess", "World Sport", "Great Sport. Propularly played by all countries.");
        List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
        list.add(post1);
        list.add(post2);
        list.add(post3);
        // when
        when(service.getAllPosts()).thenReturn(list);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllPosts")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	@Test 
	public void testGetAllDiscussions() throws Exception { 
		// Given input
		VisitorPostsDto post1 = JSONUtils.createPostDto("1", "First", "Kabbadi", "India Sport", "Good Sport. Propularly played by all eastern countries.");
		VisitorPostsDto post2 = JSONUtils.createPostDto("2", "Second", "Ko Ko", "India Sport", "Good Sport. Propularly played by all states in India.");
		VisitorPostsDto post3 = JSONUtils.createPostDto("3", "Third", "Chess", "World Sport", "Great Sport. Propularly played by all countries.");
        List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
        list.add(post1);
        list.add(post2);
        list.add(post3);
	    HashMap<String, String> discussion = new HashMap<String, String>();
		if(!CollectionUtils.isEmpty(list)) {
			for(VisitorPostsDto p : list) {
				discussion.put(p.getId(), p.getTitle());
			}
		}
	    // when
	    when(this.service.getDiscussions()).thenReturn(discussion);
	    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getDiscussionList")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
		  

}

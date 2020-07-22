package com.iiht.forum.exceptionTestCases;

import static com.iiht.forum.UtilTestClass.TestUtils.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.forum.UtilTestClass.JSONUtils;
import com.iiht.forum.controller.VisitorCommentController;
import com.iiht.forum.controller.VisitorPostController;
import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.service.CommentService;
import com.iiht.forum.service.PostService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(controllers = {VisitorPostController.class, VisitorCommentController.class})
public class ExceptionTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PostService postService;

	@MockBean
	private CommentService commentService;
	
	@Test 
	public void testGetPostByIdException() throws Exception { 
		VisitorPostsDto visitorPostsDto = JSONUtils.createPostDto("1", "First", "Foot Ball", "Field Game", "#World Sport#Great Sport");
        
        when(this.postService.getPostById("1"))
		.thenReturn(visitorPostsDto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPostById/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), 
		exceptionTestFile);
	}
	
	@Test 
	public void testGetAllVisitorPostsException() throws Exception { 
        // Given input
		VisitorCommentsDto visitorCommentsDto1 = JSONUtils.createCommentDto("1", "First", "1",  "#World Sport#Great Sport", "Field Game");
		VisitorCommentsDto visitorCommentsDto2 = JSONUtils.createCommentDto("2", "Second", "1",  "#World Sport#Great Sport", "Healthy Game");
		VisitorCommentsDto visitorCommentsDto3 = JSONUtils.createCommentDto("3", "Third", "1",  "#World Sport#Great Sport", "Popular Game");
		List<VisitorCommentsDto> list = new ArrayList<VisitorCommentsDto>();
        list.add(visitorCommentsDto1);
        list.add(visitorCommentsDto2);
        list.add(visitorCommentsDto3);
        // when
        when(this.commentService.getCommentsByPostId("1")).thenReturn(list);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getCommentByPostId/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), 
		exceptionTestFile);
	}
}
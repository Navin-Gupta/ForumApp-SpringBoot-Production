package com.iiht.forum.boundaryTestCases;

import static com.iiht.forum.UtilTestClass.TestUtils.*;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.iiht.forum.UtilTestClass.JSONUtils;
import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;

@RunWith(SpringRunner.class)
public class TestEntityValidation
{
    private Validator validator;
	
    //----------------------------------------------------------------------------------------------
    @Before
    public void setUp()
    {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testPostSuccess() throws IOException
    {
    	VisitorPostsDto visitorPostsDto = JSONUtils.createPostDto("1", "First", "Foot Ball", "Field Game", "#World Sport#Great Sport");
    	
        Set<ConstraintViolation<VisitorPostsDto>> violations = validator.validate(visitorPostsDto);
        
	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);	    
    }
    
    //----------------------------------------------------------------------------------------------
    @Test
    public void testPostFailed() throws IOException
    {
    	VisitorPostsDto visitorPostsDto = JSONUtils.createPostDto("1", "First", "Foot Ball", "Field Game", "#World Sport#Great Sport");
    	
    	visitorPostsDto.setPostDescription(null);
    	
        Set<ConstraintViolation<VisitorPostsDto>> violations = validator.validate(visitorPostsDto);
        
	    yakshaAssert(currentTest(), !(violations.isEmpty()) ? true : false, boundaryTestFile);
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testCommentSuccess() throws IOException
    {
    	VisitorCommentsDto visitorCommentsDto = JSONUtils.createCommentDto("1", "First", "1",  "#World Sport#Great Sport", "Field Game");
    	
        Set<ConstraintViolation<VisitorCommentsDto>> violations = validator.validate(visitorCommentsDto);

	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
    }
    
    @Test
    public void testCommentFailed() throws IOException
    {
    	VisitorCommentsDto visitorCommentsDto = JSONUtils.createCommentDto("1", "First", "1",  "#World Sport#Great Sport", "Field Game");
    	
    	visitorCommentsDto.setComment(null);

    	Set<ConstraintViolation<VisitorCommentsDto>> violations = validator.validate(visitorCommentsDto);

	    yakshaAssert(currentTest(), !(violations.isEmpty()) ? true : false, boundaryTestFile);
    }
}
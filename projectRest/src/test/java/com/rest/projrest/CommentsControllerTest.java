package com.rest.projrest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.rest.projrest.controller.CommentsController;
import com.rest.projrest.model.Comment;
import com.rest.projrest.model.CommentData;
import com.rest.projrest.service.CommentRestService;

@ExtendWith(MockitoExtension.class)
public class CommentsControllerTest {

	@Mock
	CommentRestService commentRestServiceMock;

	@InjectMocks
	CommentsController controller;

	@BeforeEach
	void setUp() {
		List<Comment> comments = new ArrayList<>();
		Comment comment = new Comment();
		comment.setPostId("1");
		comment.setId("1");
		comment.setEmail("Eliseo@gardner.biz");
		comments.add(comment);

		Mockito.when(commentRestServiceMock.obtenerComments()).thenReturn(comments);
	}

	@Test
	void comment() throws Exception {
		ResponseEntity<CommentData> response = controller.comments();

		assertThat("Lista contiene 1 registro", Arrays.asList(response.getBody().getData()).size(), is(1));

	}
}

package com.rest.projrest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.projrest.model.Comment;
import com.rest.projrest.model.CommentData;
import com.rest.projrest.service.CommentRestService;

@RestController
@RequestMapping("/")
public class CommentsController {
	
	@Autowired
	private CommentRestService commentRestService;
	

	@RequestMapping(value = "comments", method = RequestMethod.POST)
	public ResponseEntity<CommentData> comments() {

		List<Comment> listComment = commentRestService.obtenerComments();

		List<String> listRestruct = listComment.stream()
							.map(Comment::getRestructura)
							.collect(Collectors.toList());

		CommentData data = new CommentData();
		data.setData(listRestruct.toArray(new String[listRestruct.size()]));

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

}

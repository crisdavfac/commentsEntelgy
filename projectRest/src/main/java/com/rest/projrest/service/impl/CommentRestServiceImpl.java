package com.rest.projrest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.projrest.model.Comment;
import com.rest.projrest.service.CommentRestService;

@Service
public class CommentRestServiceImpl implements CommentRestService {

	@Override
	public List<Comment> obtenerComments() {
		final String uri = "https://jsonplaceholder.typicode.com/comments";
		RestTemplate restTemplate = new RestTemplate();
		Comment[] result = restTemplate.getForObject(uri, Comment[].class);

		List<Comment> listComment = new ArrayList<>(Arrays.asList(result));
		return listComment;
	}

}

package com.rest.projrest.model;

import com.rest.projrest.util.Constants;

public class Comment {

	private String postId;
	private String id;
	private String email;

	public Comment() {
		super();
	}

	public Comment(String postId, String id, String email) {
		super();
		this.postId = postId;
		this.id = id;
		this.email = email;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRestructura() {
		StringBuilder sb = new StringBuilder();
		sb.append(postId).append(Constants.BARRA).append(id).append(Constants.BARRA).append(email);
		return sb.toString();
	}

}

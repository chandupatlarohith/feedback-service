package com.rohith.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {
	@JsonProperty(value = "comment")
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

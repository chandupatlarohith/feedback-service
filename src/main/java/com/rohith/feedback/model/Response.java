package com.rohith.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty("feedback")
	private String feedback;

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Response(String feedback) {
		super();
		this.feedback = feedback;
	}

}

package com.rohith.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.feedback.model.Comment;
import com.rohith.feedback.model.Response;
import com.rohith.feedback.service.CommentValidatorService;

@RestController
public class CommentValidatorController {

	@Autowired
	CommentValidatorService commentValidatorService;

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ResponseEntity<Response> isObjectionable(@RequestBody Comment comment) {
		return commentValidatorService.isObjectionable(comment)
				? new ResponseEntity(new Response("Please donot add objectionable comments."), HttpStatus.OK)
				: new ResponseEntity(new Response("Thank you for the response"), HttpStatus.OK);
	}
}

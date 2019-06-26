package com.rohith.feedback.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.rohith.feedback.model.Comment;

public class CommentValidatorServiceTest {

	@Test
	public void isObjectionbleTestEmptyComment() {
		CommentValidatorService commentValidatorService = new CommentValidatorService();
		Comment comment = new Comment("");
		assertFalse(commentValidatorService.isObjectionable(comment));
	}

	@Test
	public void isObjectionbleTestNonObjectionableCommentForPartialMatch() {
		CommentValidatorService commentValidatorService = new CommentValidatorService();
		ReflectionTestUtils.setField(commentValidatorService, "objectionableWords", Arrays.asList("hi"));
		ReflectionTestUtils.setField(commentValidatorService, "partialMatch", true);
		Comment comment = new Comment("hello ipsum");
		assertFalse(commentValidatorService.isObjectionable(comment));
	}

	@Test
	public void isObjectionbleTestObjectionableCommentForPartialMatch() {
		CommentValidatorService commentValidatorService = new CommentValidatorService();
		ReflectionTestUtils.setField(commentValidatorService, "objectionableWords", Arrays.asList("hi"));
		ReflectionTestUtils.setField(commentValidatorService, "partialMatch", true);
		Comment comment = new Comment("hie ipsum");
		assertTrue(commentValidatorService.isObjectionable(comment));
	}

	@Test
	public void isObjectionbleTestObjectionableCommentForNonPartialMatch() {
		CommentValidatorService commentValidatorService = new CommentValidatorService();
		ReflectionTestUtils.setField(commentValidatorService, "objectionableWords", Arrays.asList("hi", "there"));
		ReflectionTestUtils.setField(commentValidatorService, "partialMatch", false);
		Comment comment = new Comment("hi ipsum");
		assertTrue(commentValidatorService.isObjectionable(comment));
	}

	@Test
	public void isObjectionbleTestNonObjectionableCommentForNonPartialMatch() {
		CommentValidatorService commentValidatorService = new CommentValidatorService();
		ReflectionTestUtils.setField(commentValidatorService, "objectionableWords", Arrays.asList("hi", "there"));
		ReflectionTestUtils.setField(commentValidatorService, "partialMatch", false);
		Comment comment = new Comment("hie ipsum");
		assertFalse(commentValidatorService.isObjectionable(comment));
	}
}

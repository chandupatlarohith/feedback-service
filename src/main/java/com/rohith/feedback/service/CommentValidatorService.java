package com.rohith.feedback.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rohith.feedback.model.Comment;

@Service
public class CommentValidatorService {
	@Value("${objectionableWords}")
	List<String> objectionableWords;

	@Value("${partialMatch}")
	boolean partialMatch;

	public boolean isObjectionable(Comment comment) {
		if (partialMatch) {
			for (String objectionableWord : objectionableWords) {
				if (comment.getComment().contains(objectionableWord))
					return true;
			}
		} else {
			Pattern pattern = Pattern.compile("\\w+");
			Matcher matcher = pattern.matcher(comment.getComment());
			while (matcher.find()) {
				if (objectionableWords.contains(matcher.group())) {
					return true;
				}
			}
		}
		return false;

	}
}

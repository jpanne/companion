package com.jp.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentService.class);
	
	@RequestMapping("/{adId}")
	public List<String> getComments(@PathVariable int adId) {
		log.info("In get Ad method");
		
		
		List<String> comments = new ArrayList<>();
		comments.add("Comment 1 for Ad:"+adId);
		comments.add("Comment 2 for Ad:"+adId);

	    return comments;
	}

}

package com.jp.companion.model;

import java.util.List;

public class Ad {
	private long id;
	
	private String subject;
	private List<String> from;
	private List<String> to;
	private String message;
	private List<String> comments;
	
	public Ad() {
	}
	
	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getFrom() {
		return from;
	}

	public void setFrom(List<String> from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Ad(String subject, List<String> from, List<String> to, String message) {
		super();
		this.subject = subject;
		this.from = from;
		this.to = to;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

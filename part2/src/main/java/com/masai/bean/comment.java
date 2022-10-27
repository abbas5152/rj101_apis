package com.masai.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentid;
	
	private String data;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private post posts;

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public post getPosts() {
		return posts;
	}

	public void setPosts(post posts) {
		this.posts = posts;
	}

	public comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

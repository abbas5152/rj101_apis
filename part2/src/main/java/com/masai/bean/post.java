package com.masai.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postid;
	private String caption;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<comment> comments;

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public List<comment> getComments() {
		return comments;
	}

	public void setComments(List<comment> comments) {
		this.comments = comments;
	}

	public post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

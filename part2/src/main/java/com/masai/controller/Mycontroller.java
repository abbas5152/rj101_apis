package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.comment;
import com.masai.bean.post;
import com.masai.dao.commentDao;
import com.masai.dao.postDao;

@RestController
public class Mycontroller {
	
	@Autowired
	private commentDao cm;
	
	@Autowired
	private postDao ps;
	
	@PostMapping("/post")
	public ResponseEntity<post> savepost(@RequestBody post p){
		
		post ans= ps.save(p);
		
		return new ResponseEntity<post>(ans,HttpStatus.CREATED);
	}
	
	@PutMapping("/post")
	public ResponseEntity<post> updatepost(@RequestBody post p){
		
		
	
		
			
			
		
		
		
		return new ResponseEntity<post>(ps.save(p),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/post")
	public ResponseEntity<List<post>> Allpost(){
		
		List<post> ans= ps.findAll();
		
		
		
		return new ResponseEntity<List<post>>(ans,HttpStatus.FOUND);
	}
	
	@GetMapping("/post/{id}")
	public ResponseEntity<post> postbyid(@PathVariable int id){
		
		post ans= ps.findById(id).get();
		
		
		
		return new ResponseEntity<post>(ans,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/post/{id}")
	public ResponseEntity<post> deletepostbyid(@PathVariable int id){
		
		post ans= ps.findById(id).get();
           ps.deleteById(id);
		
		
		
		return new ResponseEntity<post>(ans,HttpStatus.FOUND);
	}
	
	@PostMapping("/post/{postid}/comments")
	public ResponseEntity<List<comment>> savecomments(@RequestBody comment c,@PathVariable int postid){
		
		post p=ps.findById(postid).get();
		p.getComments().add(c);
		cm.save(c);
		
		return new ResponseEntity<List<comment>>(p.getComments(),HttpStatus.CREATED);
	}
	
	@GetMapping("/post/{postid}/comments")
	public ResponseEntity<List<comment>> getcomments(@PathVariable int postid){
		
		post p=ps.findById(postid).get();
		
		
		return new ResponseEntity<List<comment>>(p.getComments(),HttpStatus.CREATED);
	}
	
	@GetMapping("/post/{postid}/comments/{id}")
	public ResponseEntity<comment> getcommentbyid(@PathVariable int postid,@PathVariable int id){
		
		post p=ps.findById(postid).get();
		List<comment> li=p.getComments();
		comment c=null;
		
		for(comment i:li) {
			if(i.getCommentid()==id) {
				c=i;
				break;
			}
		}
		
		
		return new ResponseEntity<comment>(c,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/post/{postid}/comments/{id}")
	public ResponseEntity<comment> deletecommentbyid(@PathVariable int postid,@PathVariable int id){
		
		post p=ps.findById(postid).get();
		List<comment> li=p.getComments();
		comment c=null;
		
		for(comment i:li) {
			if(i.getCommentid()==id) {
				c=i;
			   cm.delete(c);
			   break;
			}
		}
		
		
		return new ResponseEntity<comment>(c,HttpStatus.CREATED);
	}
	@PutMapping("/post/{postid}/comments/{id}")
	public ResponseEntity<comment> updatecommentsbyid(@PathVariable int postid,@PathVariable int id,@RequestBody comment c){
		
		post p=ps.findById(postid).get();
		List<comment> li=p.getComments();
		comment cn=null;
		
		for(comment i:li) {
			if(i.getCommentid()==id) {
				cn=cm.save(c);
			}
		}
		
		
		return new ResponseEntity<comment>(cn,HttpStatus.CREATED);
	}
	
	
	

}

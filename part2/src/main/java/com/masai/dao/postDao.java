package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.post;

public interface postDao extends JpaRepository<post, Integer> {

}

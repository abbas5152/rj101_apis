package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.comment;

public interface commentDao extends JpaRepository<comment,Integer> {

}

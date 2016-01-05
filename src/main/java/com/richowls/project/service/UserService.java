package com.richowls.project.service;

import java.util.List;

import com.richowls.project.model.User;


public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();

	void saveOrUpdate(User user);
	
	void delete(int id);
	
}
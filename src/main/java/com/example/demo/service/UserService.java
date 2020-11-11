package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;


@Service
public interface UserService {

	public List<User> findByName(String name) ;


	public int UserService(User user) ;

	public List<User> ListUser();
	
	
	public int Update(User user);
	
	public int Delete(int id);
}

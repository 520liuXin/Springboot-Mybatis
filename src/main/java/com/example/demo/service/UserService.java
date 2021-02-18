package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserInfo;
import org.springframework.stereotype.Service;




@Service
public interface UserService {

	public List<UserInfo> findByName(String name) ;

	public List<UserInfo> findByUser(UserInfo user) ;

	public int UserService(UserInfo user) ;

	public List<UserInfo> ListUser();
	
	
	public int Update(UserInfo user);
	
	public int Delete(int id);


	public  void commitTransaction();
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserDao;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public List<User> findByName(String name) {
		return userDao.findUserByName(name);
	}

	@Override
	public int UserService(User user) {
		log.info("开始插入");
		log.info("更新数据",user.toString());
		log.info("用户姓名",user.getUsername().toString());
		List<User> oldUser=userDao.findUserByName(user.getUsername());
	   	if(oldUser.size()>1){
	   		return 0;
		}
		return userDao.insertUser(user);
	}
	@Override
	public List<User> ListUser(){
		return	userDao.ListUser();
	}

	@Override
	public int Update(User user){
		return userDao.Update(user);
	}

	@Override
	public int Delete(int id){
		return userDao.delete(id);
	}
}

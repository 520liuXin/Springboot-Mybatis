package com.example.demo.mapper;



import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserDao {
	
	List<User> findUserByName(String username);
	
	public List<User> ListUser();

    User findByMobile(String mobile) ;


	public int insertUser(User user);
	
	public int delete(int id);
	
	public int Update(User user);
	
}

package com.example.demo.mapper;



import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserDao {
	
	List<UserInfo> findUserByName(String username);


	List<UserInfo> findUser(UserInfo userInfo);


	public List<UserInfo> ListUser();

	UserInfo findByMobile(String mobile) ;


	public int insertUser(UserInfo user);
	
	public int delete(int id);
	
	public int Update(UserInfo user);
	
}

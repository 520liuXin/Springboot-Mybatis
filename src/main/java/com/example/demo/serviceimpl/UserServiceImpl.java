package com.example.demo.serviceimpl;


import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserDao;
import com.example.demo.service.UserService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	/**
	 * @description 数据库事务相关 DataSourceTransactionManager TransactionDefinition
	 * @author liuxin
	 * @date 2021/2/4
	 * @return
	 **/
	@Autowired
	DataSourceTransactionManager dataSourceTransactionManager;
	@Autowired
	TransactionDefinition transactionDefinition;

	@Autowired
	private UserDao userDao;

	private final static int ZERO=0;

    private  final  static  int TEN=10;





	@Override
	public List<UserInfo> findByName(String name) {
		return userDao.findUserByName(name);
	}

	@Override
	public List<UserInfo> findByUser(UserInfo userInfo) {

		return null;
	}

	@Override
	public int UserService(UserInfo user) {
		log.info("开始插入");
		log.info("更新数据",user.toString());
		log.info("用户姓名",user.getUsername().toString());
		List<UserInfo> oldUser=userDao.findUserByName(user.getUsername());
	   	if(oldUser.size()>1){
	   		return 0;
		}
		return userDao.insertUser(user);
	}
	@Override
	public List<UserInfo> ListUser(){
		return	userDao.ListUser();
	}

	@Override
	public int Update(UserInfo user){
		return userDao.Update(user);
	}

	@Override
	public int Delete(int id){
		return userDao.delete(id);
	}



	/***
	 * @description 事务相关测试
	 * @author liuxin
	 * @date 2021/2/4 []
	 * @return void
	 **/

	/**
	 @Transactional(propagation=Propagation.REQUIRED)
	 如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
	 @Transactional(propagation=Propagation.NOT_SUPPORTED)
	 容器不为这个方法开启事务
	 @Transactional(propagation=Propagation.REQUIRES_NEW)
	 不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
	 @Transactional(propagation=Propagation.MANDATORY)
	 必须在一个已有的事务中执行,否则抛出异常
	 @Transactional(propagation=Propagation.NEVER)
	 必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)
	 @Transactional(propagation=Propagation.SUPPORTS)
	 如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
	 **/


	/**springboot 开启事务以及手动提交事务

	 需要在服务类上加上两个注解

	 @Autowired
	 DataSourceTransactionManager dataSourceTransactionManager;
	 @Autowired
	 TransactionDefinition transactionDefinition;
	 手动开启事务
	 TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
	 手动提交事务
	 dataSourceTransactionManager.commit(transactionStatus);//提交
	 手动回滚事务
	 dataSourceTransactionManager.rollback(transactionStatus);//最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交 **/
	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public void commitTransaction() {
		TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
		int i=6;
		while(i < TEN){
			UserInfo userInfo =new UserInfo();
			UserInfo user=new UserInfo();
			user.setUsername("刘信"+i);
			user.setEmail("www.799296010@qq.com"+i);
			user.setIdCard("12345678"+i);
			user.setMobile("1767381717"+i);
			user.setPassword("12432421"+i);
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			userDao.insertUser(user);
			dataSourceTransactionManager.commit(transactionStatus);//提交

		}








	}
}

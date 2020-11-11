package com.example.demo.controller;

import java.util.List;

import com.example.demo.enums.ErrorCodeAndMsg;
import com.example.demo.utils.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Slf4j
@RestController
@RequestMapping(value = "/User", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {



	@RequestMapping("/ListUser")
	@ResponseBody
	public List<User> ListUser(){
		return userservice.ListUser();
	}

	@RequestMapping("/ListUserByname")
	@ResponseBody
	public List<User> ListUserByname(String name){
		return userservice.findByName(name);
	}
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int id) {
		int result = userservice.Delete(id);
		if (result >= 1) {
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user) {
		int result = userservice.Update(user);
		if (result >= 1) {
			return "修改成功";
		} else {
			return "修改失败";
		}

	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseInfo<?> insert(@RequestBody @Validated User userDTO) {
		log.info(userDTO.toString());
		int i= userservice.UserService(userDTO);
		return new  ResponseInfo(i==1 ? ErrorCodeAndMsg.SUCCESS : ErrorCodeAndMsg.USER_FAIL);
		}
	/**
	 * 走参数校验注解
	 *
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/save/valid")
	public ResponseInfo<?> save(@RequestBody @Validated User userDTO) {
		userservice.findByName(userDTO.getUsername());
		return  new ResponseInfo(ErrorCodeAndMsg.SUCCESS,userDTO);
	}


}

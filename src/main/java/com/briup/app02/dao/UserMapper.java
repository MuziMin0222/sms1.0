package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.User;


public interface UserMapper {
	//查询所有用户
	List<User> findAll();
	
	//通过id查询用户
	User findById(long id);
	
	//保存用户信息
	void save(User user);
	
	//更新用户信息
	void update(User user);
	
	//删除用户信息
	void deleteById(long id);
}

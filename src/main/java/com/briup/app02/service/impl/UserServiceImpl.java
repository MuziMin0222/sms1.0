package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IUserService;
import com.briup.app02.bean.User;
import com.briup.app02.dao.UserMapper;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<User> list = userMapper.findAll();
		return list;
	}
	
	



	@Override
	public User findById(long id) throws Exception {
		//通过id查找学校
		User user = userMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(user!=null){
			userMapper.findById(id);
		}
		else{
			throw new Exception("要查询的用户不存在");
		}
		return user;
	}

	@Override
	public void save(User user) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(user.getName()!=null){
			userMapper.save(user);
		}
		else{
			throw new Exception("需要保存的用户不存在");
		}

	}

	@Override
	public void update(User user) throws Exception {
		//通过id查找
		User newUser = userMapper.findById(user.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newUser!=null){
			userMapper.update(user);
		}
		else{
			throw new Exception("要更新的用户不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		User user = userMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(user!=null){
			userMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的用户不存在");
		}

	}
}

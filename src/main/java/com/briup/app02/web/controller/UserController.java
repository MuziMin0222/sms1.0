package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  user
 * @return 
 * @return
 */

@Api(description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		
		try {
			List<User> list = userService.findAll();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findUserById")
	public MsgResponse findUserById(long id){
		try {
			//调用service代码来查询信息
			userService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", userService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveuser")
	public MsgResponse saveUser(User user){
		try {
			//调用service代码来保存信息
			userService.save(user);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateUser")
	public MsgResponse updateUser(User user){
		try {
			//调用service层代码更新信息
			userService.update(user);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(long id){
		try {
			//调用service层代码删除信息
			userService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

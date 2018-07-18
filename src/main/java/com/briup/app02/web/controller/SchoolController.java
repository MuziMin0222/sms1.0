package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.School;
import com.briup.app02.service.ISchoolService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  school
 * @return 
 * @return
 */


@Api(description = "学校相关接口")
@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private ISchoolService schoolService;
	
	
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool(){
		
		try {
			List<School> list = schoolService.findAll();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findSchoolById")
	public MsgResponse findSchoolById(long id){
		try {
			//调用service代码来查询信息
			schoolService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", schoolService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveschool")
	public MsgResponse saveSchool(School school){
		try {
			//调用service代码来保存信息
			schoolService.save(school);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateSchool")
	public MsgResponse updateSchool(School school){
		try {
			//调用service层代码更新信息
			schoolService.update(school);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteSchoolById")
	public MsgResponse deleteSchoolById(long id){
		try {
			//调用service层代码删除信息
			schoolService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

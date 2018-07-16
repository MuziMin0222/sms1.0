package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  course
 * @return 
 * @return
 */

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private ICourseService courseService;
	
	
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		
		try {
			List<Course> list = courseService.findAll();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findCourseById")
	public MsgResponse findCourseById(long id){
		try {
			//调用service代码来查询信息
			courseService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", courseService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("savecourse")
	public MsgResponse saveCourse(Course course){
		try {
			//调用service代码来保存信息
			courseService.save(course);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateCourse")
	public MsgResponse updateCourse(Course course){
		try {
			//调用service层代码更新信息
			courseService.update(course);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id){
		try {
			//调用service层代码删除信息
			courseService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

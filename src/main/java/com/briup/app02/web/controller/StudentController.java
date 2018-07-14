package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")

public class StudentController {
	//注入studentService的实例
	@Autowired
	private IStudentService studentService;
	@GetMapping("deleteStudentById")
	public MsgResponse deleteStudentById(long id){
		try {
			//调用service层代码删除信息
			studentService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateStudent")
	public MsgResponse updateStudent(Student student){
		try {
			//调用service层代码更新信息
			studentService.update(student);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 保存学生信息
	 * @author 李煌民
	 * @param  student
	 * @return 
	 * @return
	 */
	@PostMapping("saveStudent")
	public MsgResponse saveStudent(Student student){
		try {
			//调用service代码来保存信息
			studentService.save(student);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	//http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllStudent")
	public List<Student> findAllStudent(){
		
		try {
			List<Student> list = studentService.findAll();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("findStudentById")
	public MsgResponse findStudentById(long id){
		try {
			//调用service代码来查询信息
			studentService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", studentService.findById(id));
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

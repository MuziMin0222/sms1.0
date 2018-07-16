package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  school
 * @return 
 * @return
 */

@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private IGradeService gradeService;
	
	
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		
		try {
			List<Grade> list = gradeService.findAll();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findGradeById")
	public MsgResponse findGradeById(long id){
		try {
			//调用service代码来查询信息
			gradeService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", gradeService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("savegrade")
	public MsgResponse saveGrade(Grade grade){
		try {
			//调用service代码来保存信息
			gradeService.save(grade);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateGrade")
	public MsgResponse updateGrade(Grade grade){
		try {
			//调用service层代码更新信息
			gradeService.update(grade);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteGradeById")
	public MsgResponse deleteGradeById(long id){
		try {
			//调用service层代码删除信息
			gradeService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

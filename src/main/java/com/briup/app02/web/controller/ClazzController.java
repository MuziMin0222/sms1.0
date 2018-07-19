package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  clazz
 * @return 
 * @return
 */


@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	//注入service层的对象
	@Autowired
	private IClazzService clazzService;
	@ApiOperation(value="查询所有班级",notes = "只能查询出班级信息，并且级连查询到年级和班主任")

	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM(){

		try {
			List<ClazzVM> list = clazzService.findAllClazzVM();
			return MsgResponse.success("查询成功", list);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://ip:port/clazz/findAllClazz
	@ApiOperation(value="查询所有班级"
			,notes="只能查询出班级的基本信息，无法级联查询到年级和班主任")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz(){
		try {
			List<Clazz> list = clazzService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdClazzVM")
	public MsgResponse findByIdClazzVM(long id){
		try{
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", clazzService.findByIdClazzVM(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveclazz")
	public MsgResponse saveClazz(Clazz clazz){
		try {
			//调用service代码来保存信息
			clazzService.save(clazz);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateClazz")
	public MsgResponse updateClazz(Clazz clazz){
		try {
			//调用service层代码更新信息
			clazzService.update(clazz);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(long id){
		try {
			//调用service层代码删除信息
			clazzService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

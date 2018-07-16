package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  option
 * @return 
 * @return
 */

@RestController
@RequestMapping("/option")
public class OptionController {
	
	@Autowired
	private IOptionService optionService;
	
	
	@GetMapping("findAlloption")
	public MsgResponse findAlloption(){
		
		try {
			List<Option> list = optionService.findAll();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findOptionById")
	public MsgResponse findOptionById(long id){
		try {
			//调用service代码来查询信息
			optionService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", optionService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveoption")
	public MsgResponse saveOption(Option option){
		try {
			//调用service代码来保存信息
			optionService.save(option);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateOption")
	public MsgResponse updateOption(Option option){
		try {
			//调用service层代码更新信息
			optionService.update(option);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteOptionById")
	public MsgResponse deleteOptionById(long id){
		try {
			//调用service层代码删除信息
			optionService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QuestionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  question
 * @return 
 * @return
 */

@Api(description = "问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	
	
	@ApiOperation(value = "保存问题",notes = "保存问题的同时保存选项,id不用输入，即问题id和选项id "
			+ "选项中的外键id也不用输入")
	@PostMapping("saveQuestion")
	public MsgResponse saveQuestion(QuestionVM questionVM){
		try {
			questionService.saveQuestion(questionVM);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "查看所有问题",notes="级联查询出属于该题目的选项")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM(){
		
		try {
			List<QuestionVM> list = questionService.findAllQuestionVM();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findQuestionById")
	public MsgResponse findQuestionById(long id){
		try {
			//调用service代码来查询信息
			questionService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", questionService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdQuestionVM")
	public MsgResponse findByIdQuestionVM(long id){
		try{
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", questionService.findByIdQuestionVM(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("savequestion")
	public MsgResponse saveQuestion(Question question){
		try {
			//调用service代码来保存信息
			questionService.save(question);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateQuestion")
	public MsgResponse updateQuestion(Question question){
		try {
			//调用service层代码更新信息
			questionService.update(question);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id){
		try {
			//调用service层代码删除信息
			questionService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

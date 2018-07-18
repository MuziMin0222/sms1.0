package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Answer;
import com.briup.app02.service.IAnswerService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  answer
 * @return 
 * @return
 */

@Api(description = "回答相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	private IAnswerService answerService;
	
	
	@GetMapping("findAllAnswer")
	public MsgResponse findAllAnswer(){
		
		try {
			List<Answer> list = answerService.findAll();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findAnswerById")
	public MsgResponse findAnswerById(long id){
		try {
			//调用service代码来查询信息
			answerService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", answerService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveanswer")
	public MsgResponse saveAnswer(Answer answer){
		try {
			//调用service代码来保存信息
			answerService.save(answer);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateAnswer")
	public MsgResponse updateAnswer(Answer answer){
		try {
			//调用service层代码更新信息
			answerService.update(answer);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteAnswerById")
	public MsgResponse deleteAnswerById(long id){
		try {
			//调用service层代码删除信息
			answerService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

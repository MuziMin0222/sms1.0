package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

/**
 * 保存学生信息
 * @author 李煌民
 * @param  survey
 * @return 
 * @return
 */

@Api(description = "课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	private ISurveyService surveyService;
	
	
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		
		try {
			List<Survey> list = surveyService.findAll();
		    return MsgResponse.success("查询成功", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findSurveyById")
	public MsgResponse findSurveyById(long id){
		try {
			//调用service代码来查询信息
			surveyService.findById(id);
			//如果查询成功返回成功信息
			return MsgResponse.success("保存成功", surveyService.findById(id));
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("savesurvey")
	public MsgResponse saveSurvey(Survey survey){
		try {
			//调用service代码来保存信息
			surveyService.save(survey);
			//如果保存成功返回成功信息
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateSurvey")
	public MsgResponse updateSurvey(Survey survey){
		try {
			//调用service层代码更新信息
			surveyService.update(survey);
			//如果更新成功返回成功信息
			return MsgResponse.success("更新成功", null);
			
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(long id){
		try {
			//调用service层代码删除信息
			surveyService.deleteById(id);
			//如果删除成功返回成功信息
			return MsgResponse.success("删除成功", null);

		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端者知道问题所在；
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;

@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	
	@Override
	public List<Survey> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<Survey> list = surveyMapper.findAll();
		return list;
	}
	
	



	@Override
	public Survey findById(long id) throws Exception {
		//通过id查找学校
		Survey survey = surveyMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(survey!=null){
			surveyMapper.findById(id);
		}
		else{
			throw new Exception("要查询的课调实体不存在");
		}
		return survey;
	}

	@Override
	public void save(Survey survey) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(survey.getState()!=null){
			surveyMapper.save(survey);
		}
		else{
			throw new Exception("需要保存的课调实体不存在");
		}

	}

	@Override
	public void update(Survey survey) throws Exception {
		//通过id查找
		Survey newSurvey = surveyMapper.findById(survey.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newSurvey!=null){
			surveyMapper.update(survey);
		}
		else{
			throw new Exception("要更新的课调实体不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Survey survey = surveyMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(survey!=null){
			surveyMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的课调实体不存在");
		}

	}
}

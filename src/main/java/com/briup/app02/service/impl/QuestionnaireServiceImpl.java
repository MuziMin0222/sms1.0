package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IQuestionnaireService;
import com.briup.app02.bean.Questionnaire;
import com.briup.app02.dao.QuestionnaireMapper;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	
	@Override
	public List<Questionnaire> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<Questionnaire> list = questionnaireMapper.findAll();
		return list;
	}
	
	



	@Override
	public Questionnaire findById(long id) throws Exception {
		//通过id查找学校
		Questionnaire questionnaire = questionnaireMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(questionnaire!=null){
			questionnaireMapper.findById(id);
		}
		else{
			throw new Exception("要查询的问卷不存在");
		}
		return questionnaire;
	}

	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(questionnaire.getName()!=null){
			questionnaireMapper.save(questionnaire);
		}
		else{
			throw new Exception("需要保存的问卷不存在");
		}

	}

	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		//通过id查找
		Questionnaire newQuestionnaire = questionnaireMapper.findById(questionnaire.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newQuestionnaire!=null){
			questionnaireMapper.update(questionnaire);
		}
		else{
			throw new Exception("要更新的问卷不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Questionnaire questionnaire =questionnaireMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(questionnaire!=null){
			questionnaireMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的问卷不存在");
		}

	}
}

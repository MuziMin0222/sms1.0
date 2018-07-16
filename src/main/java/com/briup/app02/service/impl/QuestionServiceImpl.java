package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.bean.Question;
import com.briup.app02.dao.QuestionMapper;

@Service
public class QuestionServiceImpl implements IQuestionService{
	@Autowired
	private QuestionMapper questionMapper;
	
	@Override
	public List<Question> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<Question> list = questionMapper.findAll();
		return list;
	}
	
	



	@Override
	public Question findById(long id) throws Exception {
		//通过id查找学校
		Question question = questionMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(question!=null){
			questionMapper.findById(id);
		}
		else{
			throw new Exception("要查询的问题不存在");
		}
		return question;
	}

	@Override
	public void save(Question question) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(question.getName()!=null){
			questionMapper.save(question);
		}
		else{
			throw new Exception("需要保存的问题不存在");
		}

	}

	@Override
	public void update(Question question) throws Exception {
		//通过id查找
		Question newQuestion = questionMapper.findById(question.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newQuestion!=null){
			questionMapper.update(question);
		}
		else{
			throw new Exception("要更新的问题不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Question question = questionMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(question!=null){
			questionMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的问题不存在");
		}

	}
}

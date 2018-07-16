package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IAnswerService;
import com.briup.app02.bean.Answer;
import com.briup.app02.dao.AnswerMapper;

@Service
public class AnswerServiceImpl implements IAnswerService{
	@Autowired
	private AnswerMapper answerMapper;
	
	@Override
	public List<Answer> findAll() throws Exception{
		//调用answerMapper查询所有回答
		List<Answer> list = answerMapper.findAll();
		return list;
	}
	
	



	@Override
	public Answer findById(long id) throws Exception {
		//通过id查找回答
		Answer answer = answerMapper.findById(id);
		//如果回答存在，执行删除操作，如果回答不存在，则抛出异常
		if(answer!=null){
			answerMapper.findById(id);
		}
		else{
			throw new Exception("要查询的回答不存在");
		}
		return answer;
	}

	@Override
	public void save(Answer answer) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(answer.getSelection()!=null){
			answerMapper.save(answer);
		}
		else{
			throw new Exception("需要保存的回答不存在");
		}

	}

	@Override
	public void update(Answer answer) throws Exception {
		//通过id查找
		Answer newAnswer = answerMapper.findById(answer.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newAnswer!=null){
			answerMapper.update(answer);
		}
		else{
			throw new Exception("要更新的回答不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Answer answer = answerMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(answer!=null){
			answerMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的回答不存在");
		}

	}
}

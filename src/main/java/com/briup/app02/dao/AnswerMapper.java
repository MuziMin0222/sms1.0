package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface AnswerMapper {
	//查询所有的回答
	List<Answer> findAll();
	
	//通过id查找对应的回答
	Answer findById(long id);
	
	//保存回答信息
	void save(Answer answer);
	
	//更新回答信息
	void update (Answer answer);
	
	//删除回答信息
	void deleteById(long id);

}

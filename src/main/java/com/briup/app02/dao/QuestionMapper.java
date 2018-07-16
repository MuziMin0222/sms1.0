package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Question;

public interface QuestionMapper {
	//查询所有问题
	List<Question> findAll();
	
	//通过id查询问题
	Question findById(long id);
	
	//保存问题
	void save(Question question);
	
	//更新问题
	void update(Question question);
	
	//删除问题
	void deleteById(long id);

}

package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface IAnswerService {
	
	List<Answer> findAll() throws Exception;
	
	Answer findById(long id) throws Exception;
	
	void save(Answer answer) throws Exception;
	
	void update(Answer answer) throws Exception;
	
	void deleteById(long id) throws Exception;

}

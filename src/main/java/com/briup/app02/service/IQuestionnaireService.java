package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Questionnaire;

public interface IQuestionnaireService {
	
	List<Questionnaire> findAll() throws Exception;
	
	Questionnaire findById(long id) throws Exception;
	
	void save(Questionnaire questionnaire) throws Exception;
	
	void update(Questionnaire qestionnaire) throws Exception;
	
	void deleteById(long id) throws Exception;

}

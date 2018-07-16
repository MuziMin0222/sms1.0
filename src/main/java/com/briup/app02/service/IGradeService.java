package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Grade;


public interface IGradeService {
	
	List<Grade> findAll() throws Exception;
	
	Grade findById(long id) throws Exception;
	
	void save(Grade grade) throws Exception;
	
	void update(Grade grade) throws Exception;
	
	void deleteById(long id) throws Exception;

}

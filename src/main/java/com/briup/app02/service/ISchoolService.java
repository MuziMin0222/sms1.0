package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.School;

public interface ISchoolService {
	
	List<School> findAll() throws Exception;
	
	School findById(long id) throws Exception;
	
	void save(School school) throws Exception;
	
	void update(School school) throws Exception;
	
	void deleteById(long id) throws Exception;

}

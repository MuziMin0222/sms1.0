package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Survey;

public interface SurveyMapper {
	//查询所有的课调实体
	List<Survey> findAll();
	
	//通过id查询课调实体
	Survey findById(long id);
	
	//保存课调
	void save(Survey survey);
	
	//更新课调
	void update(Survey survey);
	
	//删除课调
	void deleteById(long id);

}

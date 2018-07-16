package com.briup.app02.dao;

import java.util.List;
import com.briup.app02.bean.Questionnaire;

public interface QuestionnaireMapper {
	//查询所有调查问卷
	List<Questionnaire> findAll();
	
	//通过id查询调查问卷
	Questionnaire findById(long id);
	
	//保存调查问卷
	void save(Questionnaire questionnaire);
	
	//更新调查问卷
	void update(Questionnaire questionnaire);
	
	//删除调查问卷
	void deleteById(long id);

}

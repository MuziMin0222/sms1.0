package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;


public interface ClazzMapper {
	//查询所有班级信息
	List<Clazz> findAll();
	
	//通过id查找班级
	Clazz findById(long id);
	
	//保存班级信息
	void save(Clazz clazz);
	
	//更新学生信息
	void update(Clazz clazz);
	
	//删除学生信息
	void deleteById(long id);
	

}

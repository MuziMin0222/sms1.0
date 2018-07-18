package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;


public interface ClazzMapper {
	//查询所有班级信息
	List<Clazz> findAll();

	Clazz findById(long id);
}

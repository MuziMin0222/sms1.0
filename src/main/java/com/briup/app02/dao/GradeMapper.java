package com.briup.app02.dao;


import java.util.List;

import com.briup.app02.bean.Grade;


public interface GradeMapper {
	//通过id查询年级
    List<Grade> findAll();
	
	//通过id查找对应的年级
	Grade findById(long id);
	
	//保存年级信息
	void save(Grade answer);
	
	//更新年级信息
	void update (Grade answer);
	
	//删除年级信息
	void deleteById(long id);
}

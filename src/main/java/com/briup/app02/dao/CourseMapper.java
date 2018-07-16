package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;

public interface CourseMapper {
	//查询所有的课程
	List<Course> findAll();
	
	//通过id查找课程
	Course findById(long id);
	
	//保存课程信息
	void save(Course course);
	
	//更新课程信息
	void update(Course course);
	
	//删除学生信息
	void deleteById(long id);
	

}

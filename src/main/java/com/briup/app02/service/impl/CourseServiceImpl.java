package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.ICourseService;
import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;

@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Course> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<Course> list = courseMapper.findAll();
		return list;
	}
	
	



	@Override
	public Course findById(long id) throws Exception {
		//通过id查找学校
		Course school = courseMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(school!=null){
			courseMapper.findById(id);
		}
		else{
			throw new Exception("要查询的课程不存在");
		}
		return school;
	}

	@Override
	public void save(Course course) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(course.getName()!=null){
			courseMapper.save(course);
		}
		else{
			throw new Exception("需要保存的课程不存在");
		}

	}

	@Override
	public void update(Course course) throws Exception {
		//通过id查找
		Course newCourse= courseMapper.findById(course.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newCourse!=null){
			courseMapper.update(course);
		}
		else{
			throw new Exception("要更新的课程不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Course course = courseMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(course!=null){
			courseMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的课程不存在");
		}

	}
}

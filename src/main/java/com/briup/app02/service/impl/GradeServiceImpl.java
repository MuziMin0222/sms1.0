package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IGradeService;
import com.briup.app02.bean.Grade;
import com.briup.app02.dao.GradeMapper;

@Service
public class GradeServiceImpl implements IGradeService{
	@Autowired
	private GradeMapper gradeMapper;
	
	@Override
	public List<Grade> findAll() throws Exception{
		//调用GradeMapper查询所有学校
		List<Grade> list = gradeMapper.findAll();
		return list;
	}
	
	



	@Override
	public Grade findById(long id) throws Exception {
		//通过id查找学校
		Grade grade = gradeMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(grade!=null){
			gradeMapper.findById(id);
		}
		else{
			throw new Exception("要查询的年级不存在");
		}
		return grade;
	}

	@Override
	public void save(Grade grade) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(grade.getName()!=null){
			gradeMapper.save(grade);
		}
		else{
			throw new Exception("需要保存的年级不存在");
		}

	}

	@Override
	public void update(Grade grade) throws Exception {
		//通过id查找
		Grade newGrade = gradeMapper.findById(grade.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newGrade!=null){
			gradeMapper.update(grade);
		}
		else{
			throw new Exception("要更新的年级不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Grade grade = gradeMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(grade!=null){
			gradeMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的年级不存在");
		}

	}
}

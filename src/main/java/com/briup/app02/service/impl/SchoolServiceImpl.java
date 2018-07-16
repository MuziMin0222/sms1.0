package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.ISchoolService;
import com.briup.app02.bean.School;
import com.briup.app02.dao.SchoolMapper;

@Service
public class SchoolServiceImpl implements ISchoolService{
	@Autowired
	private SchoolMapper schoolMapper;
	
	@Override
	public List<School> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<School> list = schoolMapper.findAll();
		return list;
	}
	
	



	@Override
	public School findById(long id) throws Exception {
		//通过id查找学校
		School school = schoolMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(school!=null){
			schoolMapper.findById(id);
		}
		else{
			throw new Exception("要查询的学校不存在");
		}
		return school;
	}

	@Override
	public void save(School school) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(school.getName()!=null){
			schoolMapper.save(school);
		}
		else{
			throw new Exception("需要保存的学校不存在");
		}

	}

	@Override
	public void update(School school) throws Exception {
		//通过id查找
		School newSchool = schoolMapper.findById(school.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newSchool!=null){
			schoolMapper.update(school);
		}
		else{
			throw new Exception("要更新的学校不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		School school = schoolMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(school!=null){
			schoolMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的学生不存在");
		}

	}
}

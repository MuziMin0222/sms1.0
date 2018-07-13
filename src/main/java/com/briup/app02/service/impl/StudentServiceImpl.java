package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private StudentMapper studentMapper;


	@Override
	public List<Student> findAll() throws Exception {
		//调用StudentMapper查询所有学生
		List<Student> list = studentMapper.findAll();

		return list;
	}


	@Override
	public Student findById(long id) throws Exception {
		//通过id查找
		Student student = studentMapper.findById(id);
		//如果学生存在，执行删除操作，如果学生不存在，则抛出异常
		if(student!=null){
			studentMapper.findById(id);
		}
		else{
			throw new Exception("要查询的学生不存在");
		}
		return student;
	}

	@Override
	public void save(Student student) throws Exception{
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(student.getName()!=null){
			studentMapper.save(student);
		}
		else{
			throw new Exception("需要保存的学生不存在");
		}
	}

	@Override
	public void update(Student student) throws Exception{
		//通过id查找
		Student newStudent = studentMapper.findById(student.getId());
		//如果学生存在，执行更新操作，如果学生不存在，则抛出异常
		if(newStudent!=null){
			studentMapper.update(student);
		}
		else{
			throw new Exception("要更新的学生不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception{
		//通过id查找
		Student student = studentMapper.findById(id);
		//如果学生存在，执行删除操作，如果学生不存在，则抛出异常
		if(student!=null){
			studentMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的学生不存在");
		}
	}





}

package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IClazzService;
import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;

@Service
public class ClazzServiceImpl implements IClazzService{
	@Autowired
	private ClazzMapper clazzMapper;
	
	@Override
	public List<Clazz> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<Clazz> list = clazzMapper.findAll();
		return list;
	}
	
	



	@Override
	public Clazz findById(long id) throws Exception {
		//通过id查找学校
		Clazz clazz = clazzMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(clazz!=null){
			clazzMapper.findById(id);
		}
		else{
			throw new Exception("要查询的班级不存在");
		}
		return clazz;
	}

	@Override
	public void save(Clazz clazz) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(clazz.getName()!=null){
			clazzMapper.save(clazz);
		}
		else{
			throw new Exception("需要保存的班级不存在");
		}

	}

	@Override
	public void update(Clazz clazz) throws Exception {
		//通过id查找
		Clazz newClazz = clazzMapper.findById(clazz.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newClazz!=null){
			clazzMapper.update(clazz);
		}
		else{
			throw new Exception("要更新的班级不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Clazz clazz = clazzMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(clazz!=null){
			clazzMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的班级不存在");
		}

	}
}

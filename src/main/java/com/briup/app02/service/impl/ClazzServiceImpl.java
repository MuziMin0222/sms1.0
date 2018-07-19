package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IClazzService;
import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.vm.ClazzVM;
import com.briup.app02.dao.extend.ClazzVMMapper;

@Service
public class ClazzServiceImpl implements IClazzService{
	@Autowired
	private ClazzVMMapper clazzVMMapper;
	@Autowired
	private ClazzMapper clazzMapper;

	@Override
	public List<Clazz> findAll() throws Exception{
		return clazzMapper.findAll();
	}

	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		return clazzVMMapper.findAllClazzVM();
	}

	@Override
	public Clazz findById(long id) throws Exception {
		//通过id查找回答
		Clazz clazz = clazzMapper.findById(id);
		//如果回答存在，执行删除操作，如果回答不存在，则抛出异常
		if(clazz!=null){
			clazzMapper.findById(id);
		}
		else{
			throw new Exception("要查询的班级不存在");
		}
		return clazz;
	}

	@Override
	public ClazzVM findByIdClazzVM(long id) throws Exception {
		ClazzVM clazzVM = clazzVMMapper.findByIdClazzVM(id);
		if(clazzVM!=null){
		return clazzVMMapper.findByIdClazzVM(id);
		}
		else{
			throw new Exception("要查询的班级不存在");
		}
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
		//如果班级存在，执行更新操作，如果班级不存在，则抛出异常
		if(newClazz!=null){
			clazzMapper.update(clazz);
		}
		else{
			throw new Exception("要更新的不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Clazz clazz = clazzMapper.findById(id);
		//如果班级存在，执行删除操作，如果班级不存在，则抛出异常
		if(clazz!=null){
			clazzMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的班级不存在");
		}

	}
}

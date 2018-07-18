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
}

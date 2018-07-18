package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IQqService;
import com.briup.app02.vm.QqVM;
import com.briup.app02.bean.Qq;
import com.briup.app02.dao.QqMapper;
import com.briup.app02.dao.extend.QqVMMapper;

@Service
public class QqServiceImpl implements IQqService{
	@Autowired
	private QqMapper qqMapper;
	@Autowired
	private QqVMMapper qqVMMapper;
	
	@Override
	public List<Qq> findAll() throws Exception{
		return qqMapper.findAll();
	}

	@Override
	public List<QqVM> findAllQqVM() throws Exception {
		return qqVMMapper.findAllQqVM();
	}

	@Override
	public Qq findById(long id) throws Exception {
		//通过id查找学校
		Qq qq = qqMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(qq!=null){
			qqMapper.findById(id);
		}
		else{
			throw new Exception("要查询的问卷中的问题不存在");
		}
		return qq;
	}
	
	@Override
	public QqVM findByIdQqVM(long id) throws Exception {
		QqVM qqVM = qqVMMapper.findByIdQqVM(id);
		if(qqVM!=null){
		return qqVMMapper.findByIdQqVM(id);
		}
		else{
			throw new Exception("要查询的桥表不存在");
		}
	}

	@Override
	public void save(Qq qq) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(qq.getQuestion_id()!=null){
			qqMapper.save(qq);
		}
		else{
			throw new Exception("需要保存的问卷中的问题不存在");
		}

	}

	@Override
	public void update(Qq qq) throws Exception {
		//通过id查找
		Qq newQq = qqMapper.findById(qq.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newQq!=null){
			qqMapper.update(qq);
		}
		else{
			throw new Exception("要更新的问卷中的问题不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Qq qq = qqMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(qq!=null){
			qqMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的问卷中的问题不存在");
		}

	}


}

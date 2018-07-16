package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app02.service.IOptionService;
import com.briup.app02.bean.Option;
import com.briup.app02.dao.OptionMapper;

@Service
public class OptionServiceImpl implements IOptionService{
	@Autowired
	private OptionMapper optionMapper;
	
	@Override
	public List<Option> findAll() throws Exception{
		//调用SchoolMapper查询所有学校
		List<Option> list = optionMapper.findAll();
		return list;
	}
	
	



	@Override
	public Option findById(long id) throws Exception {
		//通过id查找学校
		Option option = optionMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(option!=null){
			optionMapper.findById(id);
		}
		else{
			throw new Exception("要查询的选项不存在");
		}
		return option;
	}

	@Override
	public void save(Option option) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(option.getLabel()!=null){
			optionMapper.save(option);
		}
		else{
			throw new Exception("需要保存的选项不存在");
		}

	}

	@Override
	public void update(Option option) throws Exception {
		//通过id查找
		Option newOption = optionMapper.findById(option.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newOption!=null){
			optionMapper.update(option);
		}
		else{
			throw new Exception("要更新的选项不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Option option = optionMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(option!=null){
			optionMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的选项不存在");
		}

	}
}

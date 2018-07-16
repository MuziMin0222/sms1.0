package com.briup.app02.dao;

import java.util.List;
import com.briup.app02.bean.Qq;

public interface QqMapper {
	//查询所有问卷中的问题
	List<Qq> findAll();
	
	//通过id查询一份问卷中问题
	Qq findById(long id);
	
	//保存问卷中的问题
	void save(Qq qq);
	
	//更新问卷中的问题
	void update(Qq qq);
	
	//删除问卷中的问题
	void deleteById(long id);

}

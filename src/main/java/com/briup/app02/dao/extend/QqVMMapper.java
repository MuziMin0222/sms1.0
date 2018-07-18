package com.briup.app02.dao.extend;

import java.util.List;

import com.briup.app02.vm.QqVM;

public interface QqVMMapper {
	
	List<QqVM> findAllQqVM();
	
	QqVM findByIdQqVM(long id);

}

package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.bean.Question;
import com.briup.app02.dao.OptionMapper;
import com.briup.app02.dao.QuestionMapper;
import com.briup.app02.dao.extend.QuestionVMMapper;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.vm.QuestionVM;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private OptionMapper optionMapper;

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		return questionVMMapper.findAllQuestionVM();
	}

	@Override
	public void saveQuestion(QuestionVM questionVM) throws Exception {
		//一对多写法
		/*
		 * 将question 和option 从questionVM中剥离出来
		 * question List<Option> list
		 * 调用questionMapper.save(question)
		 * 获取刚刚保存的question的id
		 * 将所有的选项的外键设置为刚刚获取到question的id
		 * for（option option : list）{
		 *  option.setQuestionId(id)
		 *  optionMapper.save(option);
		 * }
		 */
		//剥离出来question option
		Long questionId = questionVM.getId();	//肯定null
		String questionName = questionVM.getName();
		String questionType = questionVM.getQuestiontype();
		Question question = new Question();
		List<Option> options = questionVM.getOption();
		//保存问题
		questionMapper.save(question);
		//获取刚刚保存问题的id
		long question_id = question.getId();
		//保存选项
		for(Option option : options){
			option.setQuestion_id(question_id);
			optionMapper.save(option);
		}
	}



	@Override
	public Question findById(long id) throws Exception {
		//通过id查找学校
		Question question = questionMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(question!=null){
			questionMapper.findById(id);
		}
		else{
			throw new Exception("要查询的问题不存在");
		}
		return question;
	}

	@Override
	public QuestionVM findByIdQuestionVM(long id) throws Exception {
		QuestionVM questionVM = questionVMMapper.findByIdQuestionVM(id);
		if(questionVM!=null){
			return questionVMMapper.findByIdQuestionVM(id);
		}
		else{
			throw new Exception("要查询的班级不存在");
		}
	}

	@Override
	public void save(Question question) throws Exception {
		//检查保存的属性是否存在 ，若存在，则执行保存操作，若不存在，则抛出异常
		if(question.getName()!=null){
			questionMapper.save(question);
		}
		else{
			throw new Exception("需要保存的问题不存在");
		}

	}

	@Override
	public void update(Question question) throws Exception {
		//通过id查找
		Question newQuestion = questionMapper.findById(question.getId());
		//如果学校存在，执行更新操作，如果学校不存在，则抛出异常
		if(newQuestion!=null){
			questionMapper.update(question);
		}
		else{
			throw new Exception("要更新的问题不存在");
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Question question = questionMapper.findById(id);
		//如果学校存在，执行删除操作，如果学校不存在，则抛出异常
		if(question!=null){
			questionMapper.deleteById(id);
		}
		else{
			throw new Exception("要删除的问题不存在");
		}

	}
}

package com.briup.app02.vm;

import java.util.List;

import com.briup.app02.bean.Option;

public class QuestionVM {
	private Long id;
	private String name;
	private String questiontype;
	private List<Option> options;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}
	public List<Option> getOption() {
		return options;
	}
	public void setOption(List<Option> option) {
		this.options = option;
	}

}

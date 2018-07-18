package com.briup.app02.vm;

import com.briup.app02.bean.Question;
import com.briup.app02.bean.Questionnaire;

public class QqVM {
	private Long id;
	private Question question;
	private Questionnaire questionnaire;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	

}

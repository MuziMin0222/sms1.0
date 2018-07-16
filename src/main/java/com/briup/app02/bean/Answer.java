package com.briup.app02.bean;

public class Answer {
	private Long id;
	private String selection;
	private String check;
	private String centent;
	private Long survey_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getCentent() {
		return centent;
	}
	public void setCentent(String centent) {
		this.centent = centent;
	}
	public Long getSurvey_id() {
		return survey_id;
	}
	public void setSurvey_id(Long survey_id) {
		this.survey_id = survey_id;
	}

}

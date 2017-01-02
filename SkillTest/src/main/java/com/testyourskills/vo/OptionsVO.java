package com.testyourskills.vo;
// Generated Nov 26, 2016 12:50:39 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

public class OptionsVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long optionId;
	private QuestionVO question;
	private String optnDesc;
	private Set<AnswerVO> answers = new HashSet<AnswerVO>(0);

	public OptionsVO() {
	}


	public Long getOptionId() {
		return this.optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public QuestionVO getQuestion() {
		return this.question;
	}

	public void setQuestion(QuestionVO question) {
		this.question = question;
	}

	public String getOptnDesc() {
		return this.optnDesc;
	}

	public void setOptnDesc(String optnDesc) {
		this.optnDesc = optnDesc;
	}

	public Set<AnswerVO> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set<AnswerVO> answers) {
		this.answers = answers;
	}

}

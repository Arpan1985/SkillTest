package com.testyourskills.vo;
// Generated Nov 26, 2016 12:50:39 AM by Hibernate Tools 4.3.1

public class AnswerVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9212769628308144916L;
	private Long answerId;
	private QuestionVO question;
	private OptionsVO options;

	public AnswerVO() {
	}

	public Long getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public QuestionVO getQuestion() {
		return this.question;
	}

	public void setQuestion(QuestionVO question) {
		this.question = question;
	}

	public OptionsVO getOptions() {
		return this.options;
	}

	public void setOptions(OptionsVO options) {
		this.options = options;
	}

}

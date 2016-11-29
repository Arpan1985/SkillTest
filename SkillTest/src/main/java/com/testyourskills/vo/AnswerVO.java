package com.testyourskills.vo;
// Generated Nov 26, 2016 12:50:39 AM by Hibernate Tools 4.3.1

public class AnswerVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9212769628308144916L;
	private Long answerId;
	private QuestionVO questionVO;
	private OptionsVO optionsVO;

	public AnswerVO() {
	}

	public Long getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public QuestionVO getQuestion() {
		return this.questionVO;
	}

	public void setQuestion(QuestionVO questionVO) {
		this.questionVO = questionVO;
	}

	public OptionsVO getOptions() {
		return this.optionsVO;
	}

	public void setOptions(OptionsVO optionsVO) {
		this.optionsVO = optionsVO;
	}

}

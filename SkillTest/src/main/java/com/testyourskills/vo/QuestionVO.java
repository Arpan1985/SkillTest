package com.testyourskills.vo;

import java.util.ArrayList;
import java.util.List;

public class QuestionVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2147946795677163510L;
	private Long questionId;
	private ValidTopicVO validTopicVO;
	private String qnDesc;
	private List<OptionsVO> options = new ArrayList<>();
	private List<AnswerVO> answers = new ArrayList<>();

	public QuestionVO() {
	}
	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public ValidTopicVO getValidTopic() {
		return this.validTopicVO;
	}

	public void setValidTopic(ValidTopicVO validTopicVO) {
		this.validTopicVO = validTopicVO;
	}

	public String getQnDesc() {
		return this.qnDesc;
	}

	public void setQnDesc(String qnDesc) {
		this.qnDesc = qnDesc;
	}

	public List<OptionsVO> getOptions() {
		return this.options;
	}

	public void setOptions(List<OptionsVO> options) {
		this.options = options;
	}
	public List<AnswerVO> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerVO> answers) {
		this.answers = answers;
	}
}

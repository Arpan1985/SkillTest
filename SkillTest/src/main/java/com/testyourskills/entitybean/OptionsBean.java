package com.testyourskills.entitybean;
// Generated Nov 26, 2016 12:50:39 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OptionsBean generated by hbm2java
 */
@Entity
@Table(name = "OPTIONS")
public class OptionsBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long optionId;
	private QuestionBean questionBean;
	private String optnDesc;
	private Set<AnswerBean> answerBeans = new HashSet<AnswerBean>(0);

	public OptionsBean() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "OPTION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getOptionId() {
		return this.optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUESTION_ID", nullable = false)
	public QuestionBean getQuestion() {
		return this.questionBean;
	}

	public void setQuestion(QuestionBean questionBean) {
		this.questionBean = questionBean;
	}

	@Column(name = "OPTN_DESC", nullable = false, length = 2048)
	public String getOptnDesc() {
		return this.optnDesc;
	}

	public void setOptnDesc(String optnDesc) {
		this.optnDesc = optnDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "options")
	public Set<AnswerBean> getAnswers() {
		return this.answerBeans;
	}

	public void setAnswers(Set<AnswerBean> answerBeans) {
		this.answerBeans = answerBeans;
	}

}

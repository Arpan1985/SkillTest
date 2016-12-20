package com.testyourskills.entitybean;
// Generated Nov 26, 2016 12:50:39 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getTopic",query="from ValidTopicBean vtb where vtb.topicName=:topicName ")
})
/**
 * ValidTopicBean generated by hbm2java
 */
@Entity
@Table(name = "VALID_TOPIC")
public class ValidTopicBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2121313848126772287L;
	private Long topicId;
	private String topicName;
	private Long categoryId;
	private Set<QuestionBean> questionBeans = new HashSet<QuestionBean>(0);

	public ValidTopicBean() {
	}

	@Id

	@Column(name = "TOPIC_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	@Column(name = "TOPIC_NAME", nullable = false, length = 200)
	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Column(name = "CATEGORY_ID", precision = 22, scale = 0)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "validTopic")
	public Set<QuestionBean> getQuestions() {
		return this.questionBeans;
	}

	public void setQuestions(Set<QuestionBean> questionBeans) {
		this.questionBeans = questionBeans;
	}

}

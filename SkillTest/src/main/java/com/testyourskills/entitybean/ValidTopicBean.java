package com.testyourskills.entitybean;
// Generated Jan 2, 2017 2:30:23 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getTopic",query="from ValidTopicBean vtb where lower(vtb.topicName)=:topicName ")
})
/**
 * ValidTopicBean generated by hbm2java
 */
@Entity
@Table(name = "valid_topic", catalog = "skilldb")
public class ValidTopicBean implements java.io.Serializable {

	private long topicId;
	private ValidCategoryBean validCategory;
	private String topicName;
	private Set<QuestionBean> questions = new HashSet<QuestionBean>(0);

	public ValidTopicBean() {
	}

	public ValidTopicBean(long topicId, String topicName) {
		this.topicId = topicId;
		this.topicName = topicName;
	}

	public ValidTopicBean(long topicId, ValidCategoryBean validCategory, String topicName, Set<QuestionBean> questions) {
		this.topicId = topicId;
		this.validCategory = validCategory;
		this.topicName = topicName;
		this.questions = questions;
	}

	@Id

	@Column(name = "TOPIC_ID", unique = true, nullable = false)
	public long getTopicId() {
		return this.topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	public ValidCategoryBean getValidCategory() {
		return this.validCategory;
	}

	public void setValidCategory(ValidCategoryBean validCategory) {
		this.validCategory = validCategory;
	}

	@Column(name = "TOPIC_NAME", nullable = false, length = 200)
	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "validTopic")
	public Set<QuestionBean> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<QuestionBean> questions) {
		this.questions = questions;
	}

}

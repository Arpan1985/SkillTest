package com.testyourskills.vo;

import java.util.HashSet;
import java.util.Set;

public class ValidTopicVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2121313848126772287L;
	private Long topicId;
	private String topicName;
	private Long categoryId;

	public ValidTopicVO() {
	}
	public Long getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}

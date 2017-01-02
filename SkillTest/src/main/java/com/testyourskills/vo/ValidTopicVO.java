package com.testyourskills.vo;

public class ValidTopicVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2121313848126772287L;
	private Long topicId;
	private String topicName;
	private ValidCategoryVO category;

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
	public ValidCategoryVO getCategory() {
		return category;
	}
	public void setCategory(ValidCategoryVO category) {
		this.category = category;
	}

}

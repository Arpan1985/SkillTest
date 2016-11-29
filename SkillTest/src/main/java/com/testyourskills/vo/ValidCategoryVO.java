package com.testyourskills.vo;

public class ValidCategoryVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6909061014727379424L;
	private Long categoryId;
	private String categoryName;

	public ValidCategoryVO() {
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}

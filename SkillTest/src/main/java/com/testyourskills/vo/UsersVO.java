package com.testyourskills.vo;

public class UsersVO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -978737337282927079L;
	private Long userId;
	private String userName;
	private String password;

	public UsersVO() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

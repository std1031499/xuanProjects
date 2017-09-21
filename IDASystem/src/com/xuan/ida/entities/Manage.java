package com.xuan.ida.entities;

/**
 * Manage entity. @author MyEclipse Persistence Tools
 */

public class Manage implements java.io.Serializable {

	// Fields

	private Integer manageId;
	private String manageUsername;
	private String managePassword;

	// Constructors

	/** default constructor */
	public Manage() {
	}

	/** full constructor */
	public Manage(Integer manageId, String manageUsername, String managePassword) {
		this.manageId = manageId;
		this.manageUsername = manageUsername;
		this.managePassword = managePassword;
	}

	// Property accessors

	public Integer getManageId() {
		return this.manageId;
	}

	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}

	public String getManageUsername() {
		return this.manageUsername;
	}

	public void setManageUsername(String manageUsername) {
		this.manageUsername = manageUsername;
	}

	public String getManagePassword() {
		return this.managePassword;
	}

	public void setManagePassword(String managePassword) {
		this.managePassword = managePassword;
	}

}
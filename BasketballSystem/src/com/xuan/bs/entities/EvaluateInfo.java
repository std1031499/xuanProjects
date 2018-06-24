package com.xuan.bs.entities;

/**
 * EvaluateInfo entity. @author MyEclipse Persistence Tools
 */

public class EvaluateInfo implements java.io.Serializable {

	// Fields

	private Integer evaluateId;
	private Users users;
	private String evaluateInfo;
	private Integer evaluateEvaluateId;
	private Integer teamTeamId;
	private String evaluateLevel;

	// Constructors

	/** default constructor */
	public EvaluateInfo() {
	}

	/** full constructor */
	public EvaluateInfo(Users users, String evaluateInfo,
			Integer evaluateEvaluateId, Integer teamTeamId, String evaluateLevel) {
		this.users = users;
		this.evaluateInfo = evaluateInfo;
		this.evaluateEvaluateId = evaluateEvaluateId;
		this.teamTeamId = teamTeamId;
		this.evaluateLevel = evaluateLevel;
	}

	// Property accessors

	public Integer getEvaluateId() {
		return this.evaluateId;
	}

	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getEvaluateInfo() {
		return this.evaluateInfo;
	}

	public void setEvaluateInfo(String evaluateInfo) {
		this.evaluateInfo = evaluateInfo;
	}

	public Integer getEvaluateEvaluateId() {
		return this.evaluateEvaluateId;
	}

	public void setEvaluateEvaluateId(Integer evaluateEvaluateId) {
		this.evaluateEvaluateId = evaluateEvaluateId;
	}

	public Integer getTeamTeamId() {
		return this.teamTeamId;
	}

	public void setTeamTeamId(Integer teamTeamId) {
		this.teamTeamId = teamTeamId;
	}

	public String getEvaluateLevel() {
		return this.evaluateLevel;
	}

	public void setEvaluateLevel(String evaluateLevel) {
		this.evaluateLevel = evaluateLevel;
	}

}
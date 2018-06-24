package com.xuan.bs.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Team entity. @author MyEclipse Persistence Tools
 */

public class Team implements java.io.Serializable {

	// Fields

	private Integer teamId;
	private Users users;
	private Integer teamTeamId;
	private String teamName;
	private String teamState;
	private Set matchInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Team() {
	}

	/** full constructor */
	public Team(Users users, Integer teamTeamId, String teamName,
			String teamState, Set matchInfos) {
		this.users = users;
		this.teamTeamId = teamTeamId;
		this.teamName = teamName;
		this.teamState = teamState;
		this.matchInfos = matchInfos;
	}

	// Property accessors

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getTeamTeamId() {
		return this.teamTeamId;
	}

	public void setTeamTeamId(Integer teamTeamId) {
		this.teamTeamId = teamTeamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamState() {
		return this.teamState;
	}

	public void setTeamState(String teamState) {
		this.teamState = teamState;
	}

	public Set getMatchInfos() {
		return this.matchInfos;
	}

	public void setMatchInfos(Set matchInfos) {
		this.matchInfos = matchInfos;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", users=" + users + ", teamTeamId="
				+ teamTeamId + ", teamName=" + teamName + ", teamState="
				+ teamState + ", matchInfos=" + matchInfos + "]";
	}
	
}
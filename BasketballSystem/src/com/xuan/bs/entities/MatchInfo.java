package com.xuan.bs.entities;

/**
 * MatchInfo entity. @author MyEclipse Persistence Tools
 */

public class MatchInfo implements java.io.Serializable {

	// Fields

	private Integer matchInfoId;
	private Users users;
	private MatchPosition matchPosition;
	private String matchInfoTime;
	private String matchInfoTeamType;
	private String matchInfoMatchType;
	private String matchInfoState;
	private Integer teamTeamId;

	// Constructors

	/** default constructor */
	public MatchInfo() {
	}

	/** full constructor */
	public MatchInfo(Users users, MatchPosition matchPosition,
			String matchInfoTime, String matchInfoTeamType,
			String matchInfoMatchType, String matchInfoState, Integer teamTeamId) {
		this.users = users;
		this.matchPosition = matchPosition;
		this.matchInfoTime = matchInfoTime;
		this.matchInfoTeamType = matchInfoTeamType;
		this.matchInfoMatchType = matchInfoMatchType;
		this.matchInfoState = matchInfoState;
		this.teamTeamId = teamTeamId;
	}

	// Property accessors

	public Integer getMatchInfoId() {
		return this.matchInfoId;
	}

	public void setMatchInfoId(Integer matchInfoId) {
		this.matchInfoId = matchInfoId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public MatchPosition getMatchPosition() {
		return this.matchPosition;
	}

	public void setMatchPosition(MatchPosition matchPosition) {
		this.matchPosition = matchPosition;
	}

	public String getMatchInfoTime() {
		return this.matchInfoTime;
	}

	public void setMatchInfoTime(String matchInfoTime) {
		this.matchInfoTime = matchInfoTime;
	}

	public String getMatchInfoTeamType() {
		return this.matchInfoTeamType;
	}

	public void setMatchInfoTeamType(String matchInfoTeamType) {
		this.matchInfoTeamType = matchInfoTeamType;
	}

	public String getMatchInfoMatchType() {
		return this.matchInfoMatchType;
	}

	public void setMatchInfoMatchType(String matchInfoMatchType) {
		this.matchInfoMatchType = matchInfoMatchType;
	}

	public String getMatchInfoState() {
		return this.matchInfoState;
	}

	public void setMatchInfoState(String matchInfoState) {
		this.matchInfoState = matchInfoState;
	}

	public Integer getTeamTeamId() {
		return this.teamTeamId;
	}

	public void setTeamTeamId(Integer teamTeamId) {
		this.teamTeamId = teamTeamId;
	}

	@Override
	public String toString() {
		return "MatchInfo [matchInfoId=" + matchInfoId + ", users=" + users
				+ ", matchPosition=" + matchPosition + ", matchInfoTime="
				+ matchInfoTime + ", matchInfoTeamType=" + matchInfoTeamType
				+ ", matchInfoMatchType=" + matchInfoMatchType
				+ ", matchInfoState=" + matchInfoState + ", teamTeamId="
				+ teamTeamId + "]";
	}
	
}
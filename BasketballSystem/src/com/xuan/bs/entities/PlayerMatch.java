package com.xuan.bs.entities;

/**
 * PlayerMatch entity. @author MyEclipse Persistence Tools
 */

public class PlayerMatch implements java.io.Serializable {

	// Fields

	private Integer playerMatchId;
	private Users users;
	private OrgMatch orgMatch;
	private String playMatchState;

	// Constructors

	/** default constructor */
	public PlayerMatch() {
	}

	/** full constructor */
	public PlayerMatch(Users users, OrgMatch orgMatch, String playMatchState) {
		this.users = users;
		this.orgMatch = orgMatch;
		this.playMatchState = playMatchState;
	}

	// Property accessors

	public Integer getPlayerMatchId() {
		return this.playerMatchId;
	}

	public void setPlayerMatchId(Integer playerMatchId) {
		this.playerMatchId = playerMatchId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public OrgMatch getOrgMatch() {
		return this.orgMatch;
	}

	public void setOrgMatch(OrgMatch orgMatch) {
		this.orgMatch = orgMatch;
	}

	public String getPlayMatchState() {
		return this.playMatchState;
	}

	public void setPlayMatchState(String playMatchState) {
		this.playMatchState = playMatchState;
	}


	
	

}
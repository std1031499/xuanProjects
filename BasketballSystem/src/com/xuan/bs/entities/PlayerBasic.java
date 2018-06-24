package com.xuan.bs.entities;

/**
 * PlayerBasic entity. @author MyEclipse Persistence Tools
 */

public class PlayerBasic implements java.io.Serializable {

	// Fields

	private Integer playerId;
	private Users users;
	private String playerName;
	private String playerHeight;
	private String playerSex;
	private String playerAge;
	private String playerPhone;
	private String playerIdentity;
	private String playerAddress;
	private String playerPosition;

	// Constructors

	/** default constructor */
	public PlayerBasic() {
	}

	/** full constructor */
	public PlayerBasic(Users users, String playerName, String playerHeight,
			String playerSex, String playerAge, String playerPhone,
			String playerIdentity, String playerAddress, String playerPosition) {
		this.users = users;
		this.playerName = playerName;
		this.playerHeight = playerHeight;
		this.playerSex = playerSex;
		this.playerAge = playerAge;
		this.playerPhone = playerPhone;
		this.playerIdentity = playerIdentity;
		this.playerAddress = playerAddress;
		this.playerPosition = playerPosition;
	}

	// Property accessors

	public Integer getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerHeight() {
		return this.playerHeight;
	}

	public void setPlayerHeight(String playerHeight) {
		this.playerHeight = playerHeight;
	}

	public String getPlayerSex() {
		return this.playerSex;
	}

	public void setPlayerSex(String playerSex) {
		this.playerSex = playerSex;
	}

	public String getPlayerAge() {
		return this.playerAge;
	}

	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

	public String getPlayerPhone() {
		return this.playerPhone;
	}

	public void setPlayerPhone(String playerPhone) {
		this.playerPhone = playerPhone;
	}

	public String getPlayerIdentity() {
		return this.playerIdentity;
	}

	public void setPlayerIdentity(String playerIdentity) {
		this.playerIdentity = playerIdentity;
	}

	public String getPlayerAddress() {
		return this.playerAddress;
	}

	public void setPlayerAddress(String playerAddress) {
		this.playerAddress = playerAddress;
	}

	public String getPlayerPosition() {
		return this.playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	@Override
	public String toString() {
		return "PlayerBasic [playerId=" + playerId + ", users=" + users
				+ ", playerName=" + playerName + ", playerHeight="
				+ playerHeight + ", playerSex=" + playerSex + ", playerAge="
				+ playerAge + ", playerPhone=" + playerPhone
				+ ", playerIdentity=" + playerIdentity + ", playerAddress="
				+ playerAddress + ", playerPosition=" + playerPosition + "]";
	}

}
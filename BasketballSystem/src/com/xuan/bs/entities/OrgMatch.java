package com.xuan.bs.entities;

/**
 * OrgMatch entity. @author MyEclipse Persistence Tools
 */

public class OrgMatch implements java.io.Serializable {

	// Fields

	private Integer orgMatchId;
	private Organizer organizer;
	private String orgMatchName;
	private String orgMatchTime;
	private String orgMatchIntroduction;
	private String orgMatchRule;
	private String orgMatchMap;
	private String orgMatchPosition;
	private String orgMatchJudge;
	private String orgMatchState;

	// Constructors

	/** default constructor */
	public OrgMatch() {
	}

	/** full constructor */
	public OrgMatch(Organizer organizer, String orgMatchName,
			String orgMatchTime, String orgMatchIntroduction,
			String orgMatchRule, String orgMatchMap, String orgMatchPosition,
			String orgMatchJudge, String orgMatchState) {
		this.organizer = organizer;
		this.orgMatchName = orgMatchName;
		this.orgMatchTime = orgMatchTime;
		this.orgMatchIntroduction = orgMatchIntroduction;
		this.orgMatchRule = orgMatchRule;
		this.orgMatchMap = orgMatchMap;
		this.orgMatchPosition = orgMatchPosition;
		this.orgMatchJudge = orgMatchJudge;
		this.orgMatchState = orgMatchState;
	}

	// Property accessors

	public Integer getOrgMatchId() {
		return this.orgMatchId;
	}

	public void setOrgMatchId(Integer orgMatchId) {
		this.orgMatchId = orgMatchId;
	}

	public Organizer getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public String getOrgMatchName() {
		return this.orgMatchName;
	}

	public void setOrgMatchName(String orgMatchName) {
		this.orgMatchName = orgMatchName;
	}

	public String getOrgMatchTime() {
		return this.orgMatchTime;
	}

	public void setOrgMatchTime(String orgMatchTime) {
		this.orgMatchTime = orgMatchTime;
	}

	public String getOrgMatchIntroduction() {
		return this.orgMatchIntroduction;
	}

	public void setOrgMatchIntroduction(String orgMatchIntroduction) {
		this.orgMatchIntroduction = orgMatchIntroduction;
	}

	public String getOrgMatchRule() {
		return this.orgMatchRule;
	}

	public void setOrgMatchRule(String orgMatchRule) {
		this.orgMatchRule = orgMatchRule;
	}

	public String getOrgMatchMap() {
		return this.orgMatchMap;
	}

	public void setOrgMatchMap(String orgMatchMap) {
		this.orgMatchMap = orgMatchMap;
	}

	public String getOrgMatchPosition() {
		return this.orgMatchPosition;
	}

	public void setOrgMatchPosition(String orgMatchPosition) {
		this.orgMatchPosition = orgMatchPosition;
	}

	public String getOrgMatchJudge() {
		return this.orgMatchJudge;
	}

	public void setOrgMatchJudge(String orgMatchJudge) {
		this.orgMatchJudge = orgMatchJudge;
	}

	public String getOrgMatchState() {
		return this.orgMatchState;
	}

	public void setOrgMatchState(String orgMatchState) {
		this.orgMatchState = orgMatchState;
	}

	
	
}
package com.xuan.bs.entities;

/**
 * AssMatch entity. @author MyEclipse Persistence Tools
 */

public class AssMatch implements java.io.Serializable {

	// Fields

	private Integer assMatchId;
	private Asscessor asscessor;
	private String assMatchName;
	private String assMatchTime;
	private String assMatchIntroduction;
	private String assMatchRule;
	private String assMatchMap;
	private String assMatchPosition;
	private String assMatchJudge;

	// Constructors

	/** default constructor */
	public AssMatch() {
	}

	/** full constructor */
	public AssMatch(Asscessor asscessor, String assMatchName,
			String assMatchTime, String assMatchIntroduction,
			String assMatchRule, String assMatchMap, String assMatchPosition,
			String assMatchJudge) {
		this.asscessor = asscessor;
		this.assMatchName = assMatchName;
		this.assMatchTime = assMatchTime;
		this.assMatchIntroduction = assMatchIntroduction;
		this.assMatchRule = assMatchRule;
		this.assMatchMap = assMatchMap;
		this.assMatchPosition = assMatchPosition;
		this.assMatchJudge = assMatchJudge;
	}

	// Property accessors

	public Integer getAssMatchId() {
		return this.assMatchId;
	}

	public void setAssMatchId(Integer assMatchId) {
		this.assMatchId = assMatchId;
	}

	public Asscessor getAsscessor() {
		return this.asscessor;
	}

	public void setAsscessor(Asscessor asscessor) {
		this.asscessor = asscessor;
	}

	public String getAssMatchName() {
		return this.assMatchName;
	}

	public void setAssMatchName(String assMatchName) {
		this.assMatchName = assMatchName;
	}

	public String getAssMatchTime() {
		return this.assMatchTime;
	}

	public void setAssMatchTime(String assMatchTime) {
		this.assMatchTime = assMatchTime;
	}

	public String getAssMatchIntroduction() {
		return this.assMatchIntroduction;
	}

	public void setAssMatchIntroduction(String assMatchIntroduction) {
		this.assMatchIntroduction = assMatchIntroduction;
	}

	public String getAssMatchRule() {
		return this.assMatchRule;
	}

	public void setAssMatchRule(String assMatchRule) {
		this.assMatchRule = assMatchRule;
	}

	public String getAssMatchMap() {
		return this.assMatchMap;
	}

	public void setAssMatchMap(String assMatchMap) {
		this.assMatchMap = assMatchMap;
	}

	public String getAssMatchPosition() {
		return this.assMatchPosition;
	}

	public void setAssMatchPosition(String assMatchPosition) {
		this.assMatchPosition = assMatchPosition;
	}

	public String getAssMatchJudge() {
		return this.assMatchJudge;
	}

	public void setAssMatchJudge(String assMatchJudge) {
		this.assMatchJudge = assMatchJudge;
	}

}
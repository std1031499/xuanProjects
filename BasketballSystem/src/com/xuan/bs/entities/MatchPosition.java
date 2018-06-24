package com.xuan.bs.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * MatchPosition entity. @author MyEclipse Persistence Tools
 */

public class MatchPosition implements java.io.Serializable {

	// Fields

	private Integer matchPositionId;
	private String matchPositionName;
	private Double matchPositionLongitude;
	private Double matchPositionLatitude;
	private Set matchInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public MatchPosition() {
	}

	/** minimal constructor */
	public MatchPosition(Double matchPositionLongitude,
			Double matchPositionLatitude) {
		this.matchPositionLongitude = matchPositionLongitude;
		this.matchPositionLatitude = matchPositionLatitude;
	}

	/** full constructor */
	public MatchPosition(String matchPositionName,
			Double matchPositionLongitude, Double matchPositionLatitude,
			Set matchInfos) {
		this.matchPositionName = matchPositionName;
		this.matchPositionLongitude = matchPositionLongitude;
		this.matchPositionLatitude = matchPositionLatitude;
		this.matchInfos = matchInfos;
	}

	// Property accessors

	public Integer getMatchPositionId() {
		return this.matchPositionId;
	}

	public void setMatchPositionId(Integer matchPositionId) {
		this.matchPositionId = matchPositionId;
	}

	public String getMatchPositionName() {
		return this.matchPositionName;
	}

	public void setMatchPositionName(String matchPositionName) {
		this.matchPositionName = matchPositionName;
	}

	public Double getMatchPositionLongitude() {
		return this.matchPositionLongitude;
	}

	public void setMatchPositionLongitude(Double matchPositionLongitude) {
		this.matchPositionLongitude = matchPositionLongitude;
	}

	public Double getMatchPositionLatitude() {
		return this.matchPositionLatitude;
	}

	public void setMatchPositionLatitude(Double matchPositionLatitude) {
		this.matchPositionLatitude = matchPositionLatitude;
	}

	public Set getMatchInfos() {
		return this.matchInfos;
	}

	public void setMatchInfos(Set matchInfos) {
		this.matchInfos = matchInfos;
	}

	@Override
	public String toString() {
		return "MatchPosition [matchPositionId=" + matchPositionId
				+ ", matchPositionName=" + matchPositionName
				+ ", matchPositionLongitude=" + matchPositionLongitude
				+ ", matchPositionLatitude=" + matchPositionLatitude
				+ "]";
	}
	
	
}
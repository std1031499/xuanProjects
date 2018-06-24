package com.xuan.bs.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Organizer entity. @author MyEclipse Persistence Tools
 */

public class Organizer implements java.io.Serializable {

	// Fields

	private Integer organizerId;
	private Users users;
	private String orgName;
	private String orgAddress;
	private String orgPhone;
	private String orgMail;
	private String orgDuty;
	private String orgDutyContact;
	private String orgNote;
	private Set orgMatchs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Organizer() {
	}

	/** full constructor */
	public Organizer(Users users, String orgName, String orgAddress,
			String orgPhone, String orgMail, String orgDuty,
			String orgDutyContact, String orgNote, Set orgMatchs) {
		this.users = users;
		this.orgName = orgName;
		this.orgAddress = orgAddress;
		this.orgPhone = orgPhone;
		this.orgMail = orgMail;
		this.orgDuty = orgDuty;
		this.orgDutyContact = orgDutyContact;
		this.orgNote = orgNote;
		this.orgMatchs = orgMatchs;
	}

	// Property accessors

	public Integer getOrganizerId() {
		return this.organizerId;
	}

	public void setOrganizerId(Integer organizerId) {
		this.organizerId = organizerId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgAddress() {
		return this.orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgPhone() {
		return this.orgPhone;
	}

	public void setOrgPhone(String orgPhone) {
		this.orgPhone = orgPhone;
	}

	public String getOrgMail() {
		return this.orgMail;
	}

	public void setOrgMail(String orgMail) {
		this.orgMail = orgMail;
	}

	public String getOrgDuty() {
		return this.orgDuty;
	}

	public void setOrgDuty(String orgDuty) {
		this.orgDuty = orgDuty;
	}

	public String getOrgDutyContact() {
		return this.orgDutyContact;
	}

	public void setOrgDutyContact(String orgDutyContact) {
		this.orgDutyContact = orgDutyContact;
	}

	public String getOrgNote() {
		return this.orgNote;
	}

	public void setOrgNote(String orgNote) {
		this.orgNote = orgNote;
	}

	public Set getOrgMatchs() {
		return this.orgMatchs;
	}

	public void setOrgMatchs(Set orgMatchs) {
		this.orgMatchs = orgMatchs;
	}


	
}
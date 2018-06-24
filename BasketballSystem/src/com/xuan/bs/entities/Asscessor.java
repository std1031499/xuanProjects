package com.xuan.bs.entities;

/**
 * Asscessor entity. @author MyEclipse Persistence Tools
 */

public class Asscessor implements java.io.Serializable {

	// Fields

	private Integer asscessorId;
	private Users users;
	private String assName;
	private String assAddress;
	private String assPhone;
	private String assMail;
	private String assDuty;
	private String assDutyContact;
	private String assNote;

	// Constructors

	/** default constructor */
	public Asscessor() {
	}

	/** full constructor */
	public Asscessor(Users users, String assName, String assAddress,
			String assPhone, String assMail, String assDuty,
			String assDutyContact, String assNote) {
		this.users = users;
		this.assName = assName;
		this.assAddress = assAddress;
		this.assPhone = assPhone;
		this.assMail = assMail;
		this.assDuty = assDuty;
		this.assDutyContact = assDutyContact;
		this.assNote = assNote;
	}

	// Property accessors

	public Integer getAsscessorId() {
		return this.asscessorId;
	}

	public void setAsscessorId(Integer asscessorId) {
		this.asscessorId = asscessorId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAssName() {
		return this.assName;
	}

	public void setAssName(String assName) {
		this.assName = assName;
	}

	public String getAssAddress() {
		return this.assAddress;
	}

	public void setAssAddress(String assAddress) {
		this.assAddress = assAddress;
	}

	public String getAssPhone() {
		return this.assPhone;
	}

	public void setAssPhone(String assPhone) {
		this.assPhone = assPhone;
	}

	public String getAssMail() {
		return this.assMail;
	}

	public void setAssMail(String assMail) {
		this.assMail = assMail;
	}

	public String getAssDuty() {
		return this.assDuty;
	}

	public void setAssDuty(String assDuty) {
		this.assDuty = assDuty;
	}

	public String getAssDutyContact() {
		return this.assDutyContact;
	}

	public void setAssDutyContact(String assDutyContact) {
		this.assDutyContact = assDutyContact;
	}

	public String getAssNote() {
		return this.assNote;
	}

	public void setAssNote(String assNote) {
		this.assNote = assNote;
	}

}
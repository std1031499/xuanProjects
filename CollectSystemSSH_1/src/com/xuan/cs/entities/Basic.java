package com.xuan.cs.entities;




public class Basic {
	
	private Integer basic_Id;
	
	private String c_Name;
	private String c_AddressT;
	private String c_AddressW;
	private String c_AddressE;
	private String c_Person;
	private String c_Code;
	private String c_contact;
	private String c_Phone;
	private String c_Telephone;
	private String c_Mail;
	private String c_Introduction;
	
	private String c_Property;
	
	private Integer user_IdB;
	
	//单项n-1 的关联关系
	private Management management;
	private Area area;
	
	//private User user;
		
	
	
	
	public Integer getBasic_Id() {
		return basic_Id;
	}




	public void setBasic_Id(Integer basic_Id) {
		this.basic_Id = basic_Id;
	}




	public String getC_Name() {
		return c_Name;
	}




	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}




	public String getC_AddressT() {
		return c_AddressT;
	}




	public void setC_AddressT(String c_AddressT) {
		this.c_AddressT = c_AddressT;
	}




	public String getC_AddressW() {
		return c_AddressW;
	}




	public void setC_AddressW(String c_AddressW) {
		this.c_AddressW = c_AddressW;
	}




	public String getC_AddressE() {
		return c_AddressE;
	}




	public void setC_AddressE(String c_AddressE) {
		this.c_AddressE = c_AddressE;
	}




	public String getC_Person() {
		return c_Person;
	}




	public void setC_Person(String c_Person) {
		this.c_Person = c_Person;
	}




	public String getC_Code() {
		return c_Code;
	}




	public void setC_Code(String c_Code) {
		this.c_Code = c_Code;
	}




	public String getC_contact() {
		return c_contact;
	}




	public void setC_contact(String c_contact) {
		this.c_contact = c_contact;
	}




	public String getC_Phone() {
		return c_Phone;
	}




	public void setC_Phone(String c_Phone) {
		this.c_Phone = c_Phone;
	}




	public String getC_Telephone() {
		return c_Telephone;
	}




	public void setC_Telephone(String c_Telephone) {
		this.c_Telephone = c_Telephone;
	}




	public String getC_Mail() {
		return c_Mail;
	}




	public void setC_Mail(String c_Mail) {
		this.c_Mail = c_Mail;
	}




	public String getC_Introduction() {
		return c_Introduction;
	}




	public void setC_Introduction(String c_Introduction) {
		this.c_Introduction = c_Introduction;
	}




	public String getC_Property() {
		return c_Property;
	}




	public void setC_Property(String c_Property) {
		this.c_Property = c_Property;
	}




	public Management getManagement() {
		return management;
	}




	public void setManagement(Management management) {
		this.management = management;
	}




	public Area getArea() {
		return area;
	}




	public void setArea(Area area) {
		this.area = area;
	}




	




	public Integer getUser_IdB() {
		return user_IdB;
	}




	public void setUser_IdB(Integer user_IdB) {
		this.user_IdB = user_IdB;
	}




	@Override
	public String toString() {
		return "Basic [basic_Id=" + basic_Id + ", c_Name=" + c_Name
				+ ", c_AddressT=" + c_AddressT + ", c_AddressW=" + c_AddressW
				+ ", c_AddressE=" + c_AddressE + ", c_Person=" + c_Person
				+ ", c_Code=" + c_Code + ", c_contact=" + c_contact
				+ ", c_Phone=" + c_Phone + ", c_Telephone=" + c_Telephone
				+ ", c_Mail=" + c_Mail + ", c_Introduction=" + c_Introduction
				+ ", c_Property=" + c_Property + ", user_IdB=" + user_IdB
				+ ", management=" + management + ", area=" + area + "]";
	}




	
	
	
	
}

package com.xuan.cs.entities;


public class Skill {
	
	private Integer skill_Id;
	
	private String t_Name;
	private String t_TimeMin;
	private String t_TimeMax;
	private String t_MainProblem;
	private String t_SkillKey;
	private String t_Aim;
	
	private String t_Key1;
	private String t_Key2;
	private String t_Key3;
	private String t_Key4;
	private String t_Key5;
	
	private String t_MoneySet;
	private String t_Cooperate;
	private String t_Unit;
	private String t_Type;
	
	//单项n-1的关联关系
	private ListFirst listFirst;
	private ListSecond listSecond;
	private ListThird listThird;
	
	private String t_Territory;
	
	//单项n-1的关联关系
	private TradeFirst tradeFirst;
	private TradeSecond tradeSecond;
	
	private TradeThird tradeThird;
	
	private Integer user_IdS;
	
	//查询的输入值
	private String selectInfo;
	private String inputInfo;
	
	//审核状态
	private String auditState;
	
	//审核信息
	private String auditInfomation;
		
	
	public String getAuditInfomation() {
		return auditInfomation;
	}

	public void setAuditInfomation(String auditInfomation) {
		this.auditInfomation = auditInfomation;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getSelectInfo() {
		return selectInfo;
	}

	public void setSelectInfo(String selectInfo) {
		this.selectInfo = selectInfo;
	}

	public String getInputInfo() {
		return inputInfo;
	}

	public void setInputInfo(String inputInfo) {
		this.inputInfo = inputInfo;
	}

	public Integer getSkill_Id() {
		return skill_Id;
	}

	public void setSkill_Id(Integer skill_Id) {
		this.skill_Id = skill_Id;
	}

	public String getT_Name() {
		return t_Name;
	}

	public void setT_Name(String t_Name) {
		this.t_Name = t_Name;
	}

	public String getT_TimeMin() {
		return t_TimeMin;
	}

	public void setT_TimeMin(String t_TimeMin) {
		this.t_TimeMin = t_TimeMin;
	}

	public String getT_TimeMax() {
		return t_TimeMax;
	}

	public void setT_TimeMax(String t_TimeMax) {
		this.t_TimeMax = t_TimeMax;
	}

	public String getT_MainProblem() {
		return t_MainProblem;
	}

	public void setT_MainProblem(String t_MainProblem) {
		this.t_MainProblem = t_MainProblem;
	}

	public String getT_SkillKey() {
		return t_SkillKey;
	}

	public void setT_SkillKey(String t_SkillKey) {
		this.t_SkillKey = t_SkillKey;
	}

	public String getT_Aim() {
		return t_Aim;
	}

	public void setT_Aim(String t_Aim) {
		this.t_Aim = t_Aim;
	}

	public String getT_Key1() {
		return t_Key1;
	}

	public void setT_Key1(String t_Key1) {
		this.t_Key1 = t_Key1;
	}

	public String getT_Key2() {
		return t_Key2;
	}

	public void setT_Key2(String t_Key2) {
		this.t_Key2 = t_Key2;
	}

	public String getT_Key3() {
		return t_Key3;
	}

	public void setT_Key3(String t_Key3) {
		this.t_Key3 = t_Key3;
	}

	public String getT_Key4() {
		return t_Key4;
	}

	public void setT_Key4(String t_Key4) {
		this.t_Key4 = t_Key4;
	}

	public String getT_Key5() {
		return t_Key5;
	}

	public void setT_Key5(String t_Key5) {
		this.t_Key5 = t_Key5;
	}

	public String getT_MoneySet() {
		return t_MoneySet;
	}

	public void setT_MoneySet(String t_MoneySet) {
		this.t_MoneySet = t_MoneySet;
	}

	public String getT_Cooperate() {
		return t_Cooperate;
	}

	public void setT_Cooperate(String t_Cooperate) {
		this.t_Cooperate = t_Cooperate;
	}

	public String getT_Unit() {
		return t_Unit;
	}

	public void setT_Unit(String t_Unit) {
		this.t_Unit = t_Unit;
	}

	public String getT_Type() {
		return t_Type;
	}

	public void setT_Type(String t_Type) {
		this.t_Type = t_Type;
	}

	public ListFirst getListFirst() {
		return listFirst;
	}

	public void setListFirst(ListFirst listFirst) {
		this.listFirst = listFirst;
	}

	public ListSecond getListSecond() {
		return listSecond;
	}

	public void setListSecond(ListSecond listSecond) {
		this.listSecond = listSecond;
	}

	public ListThird getListThird() {
		return listThird;
	}

	public void setListThird(ListThird listThird) {
		this.listThird = listThird;
	}

	public String getT_Territory() {
		return t_Territory;
	}

	public void setT_Territory(String t_Territory) {
		this.t_Territory = t_Territory;
	}

	public TradeFirst getTradeFirst() {
		return tradeFirst;
	}

	public void setTradeFirst(TradeFirst tradeFirst) {
		this.tradeFirst = tradeFirst;
	}

	public TradeSecond getTradeSecond() {
		return tradeSecond;
	}

	public void setTradeSecond(TradeSecond tradeSecond) {
		this.tradeSecond = tradeSecond;
	}

	public TradeThird getTradeThird() {
		return tradeThird;
	}

	public void setTradeThird(TradeThird tradeThird) {
		this.tradeThird = tradeThird;
	}

	public Integer getUser_IdS() {
		return user_IdS;
	}

	public void setUser_IdS(Integer user_IdS) {
		this.user_IdS = user_IdS;
	}

	@Override
	public String toString() {
		return "Skill [skill_Id=" + skill_Id + ", t_Name=" + t_Name
				+ ", t_TimeMin=" + t_TimeMin + ", t_TimeMax=" + t_TimeMax
				+ ", t_MainProblem=" + t_MainProblem + ", t_SkillKey="
				+ t_SkillKey + ", t_Aim=" + t_Aim + ", t_Key1=" + t_Key1
				+ ", t_Key2=" + t_Key2 + ", t_Key3=" + t_Key3 + ", t_Key4="
				+ t_Key4 + ", t_Key5=" + t_Key5 + ", t_MoneySet=" + t_MoneySet
				+ ", t_Cooperate=" + t_Cooperate + ", t_Unit=" + t_Unit
				+ ", t_Type=" + t_Type + ", listFirst=" + listFirst
				+ ", listSecond=" + listSecond + ", listThird=" + listThird
				+ ", t_Territory=" + t_Territory + ", tradeFirst=" + tradeFirst
				+ ", tradeSecond=" + tradeSecond + ", tradeThird=" + tradeThird
				+ ", user_IdS=" + user_IdS + "]";
	}

	
	

	

	
	
	
	
	
	
	
	
	
	
}

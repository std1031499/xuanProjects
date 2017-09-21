package com.xuan.ida.entities;

/**
 * DataOutput entity. @author MyEclipse Persistence Tools
 */

public class DataOutput implements java.io.Serializable {

	// Fields

	private String outputId;
	private String outputCustomerName;
	private String outputCustomerArea;
	private String outputInvoiceNum;
	private String outputInvoiceDate;
	private String outputMoney;
	private String outputTax;
	private String outputMoneySum;
	private String outputRemark;

	// Constructors

	/** default constructor */
	public DataOutput() {
	}

	/** minimal constructor */
	public DataOutput(String outputId, String outputCustomerName,
			String outputCustomerArea, String outputInvoiceNum,
			String outputInvoiceDate, String outputMoney, String outputTax,
			String outputMoneySum) {
		this.outputId = outputId;
		this.outputCustomerName = outputCustomerName;
		this.outputCustomerArea = outputCustomerArea;
		this.outputInvoiceNum = outputInvoiceNum;
		this.outputInvoiceDate = outputInvoiceDate;
		this.outputMoney = outputMoney;
		this.outputTax = outputTax;
		this.outputMoneySum = outputMoneySum;
	}

	/** full constructor */
	public DataOutput(String outputId, String outputCustomerName,
			String outputCustomerArea, String outputInvoiceNum,
			String outputInvoiceDate, String outputMoney, String outputTax,
			String outputMoneySum, String outputRemark) {
		this.outputId = outputId;
		this.outputCustomerName = outputCustomerName;
		this.outputCustomerArea = outputCustomerArea;
		this.outputInvoiceNum = outputInvoiceNum;
		this.outputInvoiceDate = outputInvoiceDate;
		this.outputMoney = outputMoney;
		this.outputTax = outputTax;
		this.outputMoneySum = outputMoneySum;
		this.outputRemark = outputRemark;
	}

	// Property accessors

	public String getOutputId() {
		return this.outputId;
	}

	public void setOutputId(String outputId) {
		this.outputId = outputId;
	}

	public String getOutputCustomerName() {
		return this.outputCustomerName;
	}

	public void setOutputCustomerName(String outputCustomerName) {
		this.outputCustomerName = outputCustomerName;
	}

	public String getOutputCustomerArea() {
		return this.outputCustomerArea;
	}

	public void setOutputCustomerArea(String outputCustomerArea) {
		this.outputCustomerArea = outputCustomerArea;
	}

	public String getOutputInvoiceNum() {
		return this.outputInvoiceNum;
	}

	public void setOutputInvoiceNum(String outputInvoiceNum) {
		this.outputInvoiceNum = outputInvoiceNum;
	}

	public String getOutputInvoiceDate() {
		return this.outputInvoiceDate;
	}

	public void setOutputInvoiceDate(String outputInvoiceDate) {
		this.outputInvoiceDate = outputInvoiceDate;
	}

	public String getOutputMoney() {
		return this.outputMoney;
	}

	public void setOutputMoney(String outputMoney) {
		this.outputMoney = outputMoney;
	}

	public String getOutputTax() {
		return this.outputTax;
	}

	public void setOutputTax(String outputTax) {
		this.outputTax = outputTax;
	}

	public String getOutputMoneySum() {
		return this.outputMoneySum;
	}

	public void setOutputMoneySum(String outputMoneySum) {
		this.outputMoneySum = outputMoneySum;
	}

	public String getOutputRemark() {
		return this.outputRemark;
	}

	public void setOutputRemark(String outputRemark) {
		this.outputRemark = outputRemark;
	}

}
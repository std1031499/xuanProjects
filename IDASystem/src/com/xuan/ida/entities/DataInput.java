package com.xuan.ida.entities;

/**
 * DataInput entity. @author MyEclipse Persistence Tools
 */

public class DataInput implements java.io.Serializable {

	// Fields

	private String inputId;
	private String inputSupplierName;
	private String inputInvoiceNum;
	private String inputInvoiceDate;
	private String inputMoney;
	private String inputTax;
	private String inputMoneySum;
	private String inputRemark;

	// Constructors

	/** default constructor */
	public DataInput() {
	}

	/** minimal constructor */
	public DataInput(String inputId, String inputSupplierName,
			String inputInvoiceNum, String inputInvoiceDate, String inputMoney,
			String inputTax, String inputMoneySum) {
		this.inputId = inputId;
		this.inputSupplierName = inputSupplierName;
		this.inputInvoiceNum = inputInvoiceNum;
		this.inputInvoiceDate = inputInvoiceDate;
		this.inputMoney = inputMoney;
		this.inputTax = inputTax;
		this.inputMoneySum = inputMoneySum;
	}

	/** full constructor */
	public DataInput(String inputId, String inputSupplierName,
			String inputInvoiceNum, String inputInvoiceDate, String inputMoney,
			String inputTax, String inputMoneySum, String inputRemark) {
		this.inputId = inputId;
		this.inputSupplierName = inputSupplierName;
		this.inputInvoiceNum = inputInvoiceNum;
		this.inputInvoiceDate = inputInvoiceDate;
		this.inputMoney = inputMoney;
		this.inputTax = inputTax;
		this.inputMoneySum = inputMoneySum;
		this.inputRemark = inputRemark;
	}

	// Property accessors

	public String getInputId() {
		return this.inputId;
	}

	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	public String getInputSupplierName() {
		return this.inputSupplierName;
	}

	public void setInputSupplierName(String inputSupplierName) {
		this.inputSupplierName = inputSupplierName;
	}

	public String getInputInvoiceNum() {
		return this.inputInvoiceNum;
	}

	public void setInputInvoiceNum(String inputInvoiceNum) {
		this.inputInvoiceNum = inputInvoiceNum;
	}

	public String getInputInvoiceDate() {
		return this.inputInvoiceDate;
	}

	public void setInputInvoiceDate(String inputInvoiceDate) {
		this.inputInvoiceDate = inputInvoiceDate;
	}

	public String getInputMoney() {
		return this.inputMoney;
	}

	public void setInputMoney(String inputMoney) {
		this.inputMoney = inputMoney;
	}

	public String getInputTax() {
		return this.inputTax;
	}

	public void setInputTax(String inputTax) {
		this.inputTax = inputTax;
	}

	public String getInputMoneySum() {
		return this.inputMoneySum;
	}

	public void setInputMoneySum(String inputMoneySum) {
		this.inputMoneySum = inputMoneySum;
	}

	public String getInputRemark() {
		return this.inputRemark;
	}

	public void setInputRemark(String inputRemark) {
		this.inputRemark = inputRemark;
	}

}
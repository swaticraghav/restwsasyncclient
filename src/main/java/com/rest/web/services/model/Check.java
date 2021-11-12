package com.rest.web.services.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Check {
	private String checkNumber;
	private String accountNumber;
	private String amount;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}

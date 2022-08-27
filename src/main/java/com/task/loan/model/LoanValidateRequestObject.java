package com.task.loan.model;

import org.springframework.stereotype.Component;

@Component
public class LoanValidateRequestObject {


	private String pcode;


	private double lAmount;
	private Integer lterm;


	public String getPcode() {
		return pcode;
	}


	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


	public double getlAmount() {
		return lAmount;
	}


	public void setlAmount(double lAmount) {
		this.lAmount = lAmount;
	}


	public Integer getLterm() {
		return lterm;
	}


	public void setLterm(Integer lterm) {
		this.lterm = lterm;
	}


	@Override
	public String toString() {
		return "LoanValidateRequestObject [pcode=" + pcode + ", lAmount=" + lAmount + ", lterm=" + lterm + "]";
	}

}

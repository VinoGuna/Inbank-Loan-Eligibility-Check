package com.task.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "checkeligibility")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;

	@Column(name = "PersonalCode")
	private String personalCode;

	@Column(name = "RequestedAmount")
	private String requestedAmount;

	@Column(name = "LoanPeriod")
	private long loanPeriod;

	@Column(name = "CreditModifier")
	private String creditModifier;

	@Column(name = "Decision")
	private String decision;

	@Column(name = "EligibileAmount")
	private String eligibileAmount;

	public Loan(String personalCode, String requestedAmount, long loanPeriod, String creditModifier, String decision,
			String eligibileAmount) {
		super();
		this.personalCode = personalCode;
		this.requestedAmount = requestedAmount;
		this.loanPeriod = loanPeriod;
		this.creditModifier = creditModifier;
		this.decision = decision;
		this.eligibileAmount = eligibileAmount;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	public String getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(String requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public long getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(long loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public String getCreditModifier() {
		return creditModifier;
	}

	public void setCreditModifier(String creditModifier) {
		this.creditModifier = creditModifier;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getEligibileAmount() {
		return eligibileAmount;
	}

	@Override
	public String toString() {
		return "Loan [personalCode=" + personalCode + ", requestedAmount=" + requestedAmount + ", loanPeriod="
				+ loanPeriod + ", creditModifier=" + creditModifier + ", decision=" + decision + ", eligibileAmount="
				+ eligibileAmount + "]";
	}

	public void setEligibileAmount(String eligibileAmount) {
		this.eligibileAmount = eligibileAmount;
	}

}

package com.task.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "credit_Modifier")
public class CreditInfoModel {
	
	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	public String getCreditModifier() {
		return creditModifier;
	}

	public void setCreditModifier(String creditModifier) {
		this.creditModifier = creditModifier;
	}

	public CreditInfoModel(String personalCode, String creditModifier) {
		super();
		this.personalCode = personalCode;
		this.creditModifier = creditModifier;
	}

	@Override
	public String toString() {
		return "CreditInfoModel [personalCode=" + personalCode + ", creditModifier=" + creditModifier + "]";
	}

	public CreditInfoModel() {
		super();
	}

	@Id
	@Column(name = "PersonalCode")
	private String personalCode;

	@Column(name = "CreditModifier")
	private String creditModifier;
	
	
	
	

}

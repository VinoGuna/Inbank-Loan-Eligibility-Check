package com.task.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.loan.constant.Constant;
import com.task.loan.model.LoanValidateRequestObject;
import com.task.loan.repository.LoancheckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vinodhini
 *
 */
@Service
public class LoanService {

	@Autowired
	LoancheckRepository loanCheckRepo;

	public String checkValidity(LoanValidateRequestObject loanRequest) {

		
		/**
		 * Below commented code is to fetch credit Modifier from Database table credit_Modifier
		 *
		 */		

		/*
		 * Optional<CreditInfoModel> credit =
		 * loanCheckRepo.findById(loanRequest.getPcode()); if (!credit.isPresent())
		 * return "Not a Valid customer";
		 * 
		 * final Integer creditModifier =
		 * Integer.valueOf(credit.get().getCreditModifier());
		 */
		final Logger logger = LoggerFactory.getLogger(LoanService.class);
		
		final Integer creditModifier = getCreditModifier(loanRequest.getPcode());
		
		logger.info("Logged in Personal code" +loanRequest.getPcode());

		final double creditScore = (creditModifier / loanRequest.getlAmount()) * loanRequest.getLterm();
		
		logger.info("creditScore for the user" +creditScore);

		if (creditScore == -1) {
			return Constant.PERSONAL_ID_NOT_VALID;
		}
		if (creditScore == 0) {
			return Constant.LOAN_NOT_ELIGIBLE;
		} else if (creditScore < 1) {
			return getNegativeLoanResponseDecision(loanRequest,creditModifier);
		} else {
			return getLoanResponseDecision(loanRequest, creditScore, creditModifier);
		}

	}

	private String getNegativeLoanResponseDecision(LoanValidateRequestObject loanRequest,
			Integer creditModifier) {


		if (loanRequest.getLterm() >= 12 && loanRequest.getLterm() <= 60) {

			return getLoanEligibility(loanRequest.getLterm(), loanRequest.getlAmount(), creditModifier);

		}

		return Constant.LOAN_AMOUNT;

	}
	
	/**
	 * Loan Eligibility check for credit score > 1 and limiting amount between 2000 and 1000 Euros.
	 *
	 */

	private String getLoanResponseDecision(LoanValidateRequestObject loanRequest, double creditScore,
			Integer creditModifier) {
		int approvedLoanAmount = (loanRequest.getLterm() * creditModifier);
		if (approvedLoanAmount > 10000) {
			approvedLoanAmount = 10000;
		} else if (approvedLoanAmount < 2000) {
			approvedLoanAmount = 2000;
		}
		return Constant.LOAN_ELIGIBLE + approvedLoanAmount + Constant.EURO + Constant.LOANTERM;

	}
	
	/**
	 * check Maximum possible loan Eligibility
	 *
	 */

	static String getLoanEligibility(int loanTerm, double amount, int creditModifier) {
    StringBuilder str= new StringBuilder(); 
		double creditScore = (creditModifier / amount) * loanTerm;

		double actualCreditScore = creditScore;
		int modifiedLoanTerm = loanTerm;
		while(creditScore < 1) {
			modifiedLoanTerm++ ;
			creditScore = (creditModifier / amount) * modifiedLoanTerm;
		}
		
		String termIncrease = Constant.TERM_INCREASE + modifiedLoanTerm + " ";
		
		if(modifiedLoanTerm<=60)
			str.append(termIncrease+" ");

		while (actualCreditScore < 1) {

			amount = amount - 100;
			actualCreditScore = (creditModifier / amount) * loanTerm;

		}
		
		str.append(Constant.REDUCE_AMOUNT + amount + Constant.EURO + " " + Constant.GET_ELIGIBILITY);

		return str.toString();
	
	}

	private Integer getCreditModifier(String personalCode) {

		switch (personalCode) {
		case "49002010965":
			return 0;
		case "49002010976":
			return 100;
		case "49002010987":
			return 300;
		case "49002010998":
			return 1000;
		}
		return -1;
	}

}

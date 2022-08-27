package com.task.loan.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.task.loan.model.LoanValidateRequestObject;


class LoanServiceTest {

	@Test
	void testCheckValidity_debt() {
		LoanValidateRequestObject loan = new LoanValidateRequestObject();
		loan.setlAmount(2000);
		loan.setLterm(12);
		loan.setPcode("49002010965");
		LoanService loanService = new LoanService();

		Assert.assertEquals("Sorry, You are not eligible for the loan.", loanService.checkValidity(loan));
	}

	@Test
	void testCheckValidity_segment1Negative() {
		LoanValidateRequestObject loan = new LoanValidateRequestObject();
		loan.setlAmount(4000);
		loan.setLterm(24);
		loan.setPcode("49002010976");
		LoanService loanService = new LoanService();

		Assert.assertNotSame("Kindly increase loan term to get the loan Eligibility", loanService.checkValidity(loan));
	}
	
	@Test
	void testCheckValidity_segment1Positive() {
		LoanValidateRequestObject loan = new LoanValidateRequestObject();
		loan.setlAmount(6000);
		loan.setLterm(45);
		loan.setPcode("49002010976");
		LoanService loanService = new LoanService();

		Assert.assertNotSame("Try increasing the loan period to 60 months or reduce your loan amount to 4500.0€ to get loan eligibility.", loanService.checkValidity(loan));
	}

	@Test
	void testCheckValidity_segment2() {
		LoanValidateRequestObject loan = new LoanValidateRequestObject();
		loan.setlAmount(6000);
		loan.setLterm(15);
		loan.setPcode("49002010987");
		LoanService loanService = new LoanService();

		Assert.assertNotSame("Kindly increase loan term to get the loan Eligibility", loanService.checkValidity(loan));
	}

	@Test
	void testCheckValidity_segment3() {
		LoanValidateRequestObject loan = new LoanValidateRequestObject();
		loan.setlAmount(7000);
		loan.setLterm(35);
		loan.setPcode("49002010998");
		LoanService loanService = new LoanService();

		Assert.assertEquals("You are eligible for a maximum loan amount of 10000€ for the given loan period", loanService.checkValidity(loan));
	}

}

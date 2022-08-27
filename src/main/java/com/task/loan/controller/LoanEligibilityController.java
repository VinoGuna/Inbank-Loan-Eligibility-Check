package com.task.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task.loan.constant.Constant;
import com.task.loan.model.LoanValidateRequestObject;
import com.task.loan.service.LoanService;

@Controller
@RequestMapping("/loan")
public class LoanEligibilityController {

	@Autowired
	private LoanService loanService;

	@RequestMapping("")
	public String indexPage() {
		return "loanForm";
	}

	@RequestMapping(value = "/validateForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String display(LoanValidateRequestObject loanValueObject, Model model) {
		String value = "";
		if (loanValueObject.getlAmount() <= 10000 && loanValueObject.getlAmount() >= 2000)
			value = loanService.checkValidity(loanValueObject);
		else
			value = Constant.AMOUNT_RANGE;	
		model.addAttribute("errorMsg", value);

		return "loanForm";
	}

}

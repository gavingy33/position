package com.lsheep.customer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsheep.common.dto.MutualDTO;
import com.lsheep.customer.constant.CustomerConstant;
import com.lsheep.customer.dto.CustomerDTO;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public MutualDTO<CustomerDTO> queryCustomer() {
		MutualDTO<CustomerDTO> mutualDTO = new MutualDTO<>();
		try {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(CustomerConstant.VISITOR);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mutualDTO;
	}

}

package com.lsheep.customer.service;

import com.lsheep.customer.dto.SignupDTO;

public interface AccountService {

	void signup(SignupDTO signupDTO);

	void signin();

	void signout();

}

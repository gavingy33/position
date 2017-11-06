package com.lsheep.customer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lsheep.common.util.ParamsCheck;
import com.lsheep.customer.dto.SignupDTO;
import com.lsheep.customer.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Override
	public void signup(SignupDTO signupDTO) {
		ParamsCheck.notNull("", signupDTO);
		LOGGER.info(JSON.toJSONString(signupDTO));
	}

	@Override
	public void signin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void signout() {
		// TODO Auto-generated method stub

	}

}

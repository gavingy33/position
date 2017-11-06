package com.lsheep.authority.service.impl;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

import com.lsheep.authority.dto.AuthDTO;
import com.lsheep.authority.dto.AuthResult;
import com.lsheep.authority.dto.AuthStatus;
import com.lsheep.authority.service.AuthService;
import com.lsheep.customer.constant.CustomerConstant;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public AuthResult auth(AuthDTO authDTO) {
		String requestURI = authDTO.getRequestURI();
		Cookie identity = authDTO.getIdentity();
		String customerId = CustomerConstant.VISITOR;
		if (identity != null && identity.getValue() != null) {
			customerId = identity.getValue();
		}
		AuthResult authResult = new AuthResult();
		authResult.setCustomerId(customerId);
		// TODO
		authResult.setStatus(AuthStatus.PASS);
		return authResult;
	}

}

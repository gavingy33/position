package com.lsheep.authority.service;

import com.lsheep.authority.dto.AuthDTO;
import com.lsheep.authority.dto.AuthResult;

public interface AuthService {

	AuthResult auth(AuthDTO authDTO);

}

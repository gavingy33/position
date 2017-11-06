package com.lsheep.customer.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.Constants;
import com.lsheep.common.dto.MutualDTO;
import com.lsheep.common.handler.ExceptionHandler;
import com.lsheep.common.util.ParamsCheck;
import com.lsheep.customer.dto.SignupDTO;
import com.lsheep.customer.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Resource
	private AccountService accountService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public MutualDTO<?> signup(@ModelAttribute SignupDTO signupDTO, HttpServletRequest request) {
		LOGGER.info("用户注册入参:{}", JSON.toJSONString(signupDTO));
		MutualDTO<?> mutualDTO = new MutualDTO<>();
		try {
			ParamsCheck.notNull("注册对象不能为空", signupDTO);
			String expectCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
			ParamsCheck.notNull("请获取验证码", expectCode);
			String actualCode = signupDTO.getValidateCode();
			ParamsCheck.notNull("请输入验证码", actualCode);
			ParamsCheck.equalsIgnoreCase("验证码输入错误", expectCode, actualCode);
			accountService.signup(signupDTO);
		} catch (Exception e) {
			ExceptionHandler.handleException(mutualDTO, e);
		}
		return mutualDTO;
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public void redirect(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("http://www.baidu.com");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

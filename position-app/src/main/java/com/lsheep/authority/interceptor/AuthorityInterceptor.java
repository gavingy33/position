package com.lsheep.authority.interceptor;

import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.lsheep.authority.constant.CookieConstant;
import com.lsheep.authority.dto.AuthDTO;
import com.lsheep.authority.dto.AuthResult;
import com.lsheep.authority.dto.AuthStatus;
import com.lsheep.authority.service.AuthService;
import com.lsheep.authority.session.CustomerContext;
import com.lsheep.authority.session.CustomerSession;
import com.lsheep.common.dto.MutualDTO;
import com.lsheep.common.dto.MutualStatus;
import com.lsheep.common.util.CookieUtils;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityInterceptor.class);

	@Resource
	private AuthService authService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.debug("invoke preHandle");
		Cookie identity = CookieUtils.getCookie(request.getCookies(), CookieConstant.CUSTOMER_IDENTITY);
		AuthDTO authDTO = new AuthDTO();
		authDTO.setIdentity(identity);
		authDTO.setRequestURI(request.getRequestURI());
		AuthResult authResult = authService.auth(authDTO);
		if (AuthStatus.PASS == authResult.getStatus()) {
			CustomerSession customerSession = new CustomerSession();
			customerSession.setCustomerId(authResult.getCustomerId());
			CustomerContext.setSession(customerSession);
			return true;
		}
		OutputStream outputStream = response.getOutputStream();
		MutualDTO<?> mutualDTO = new MutualDTO<>();
		mutualDTO.setStatus(MutualStatus.REDIRECT);
		mutualDTO.setRedirect(authResult.getRedirect());
		outputStream.write(JSON.toJSONString(mutualDTO).getBytes(Charset.forName("UTF-8")));
		outputStream.flush();
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		CustomerContext.remove();
		super.afterCompletion(request, response, handler, ex);
	}

}

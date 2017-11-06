package com.lsheep.common.util;

import javax.servlet.http.Cookie;

public abstract class CookieUtils {

	protected CookieUtils() {
	}

	public static Cookie getCookie(Cookie[] cookies, String name) {
		ParamsCheck.notEmpty("cookie's name can't be null", name);
		if (cookies == null || cookies.length == 0) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}
}

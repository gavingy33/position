package com.lsheep.common.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.lsheep.common.dto.MutualDTO;
import com.lsheep.common.dto.MutualStatus;
import com.lsheep.common.exception.ParamsCheckException;

public abstract class ExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

	public static void handleException(Exception e) {
		if (e instanceof ParamsCheckException) {
			LOGGER.info(e.getMessage());
			return;
		}
		LOGGER.error("系统异常", e);
	}

	public static void handleException(MutualDTO<?> mutualDTO, Exception e) {
		mutualDTO.setStatus(MutualStatus.FAIL);
		mutualDTO.setError(e.getMessage());
		if (e instanceof ParamsCheckException) {
			LOGGER.info(e.getMessage());
			return;
		}
		LOGGER.error("系统异常", e);
		if (StringUtils.isEmpty(mutualDTO.getError())) {
			mutualDTO.setError("系统错误");
		}
	}

}

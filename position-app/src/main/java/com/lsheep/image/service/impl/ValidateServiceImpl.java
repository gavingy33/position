package com.lsheep.image.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.code.kaptcha.Producer;
import com.lsheep.image.dto.ValidateImageDTO;
import com.lsheep.image.service.ValidateService;

@Service
public class ValidateServiceImpl implements ValidateService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Resource
	private Producer producer;

	@Override
	public ValidateImageDTO produce() {
		ValidateImageDTO validateImageDTO = new ValidateImageDTO();
		String validateCode = producer.createText();
		LOGGER.debug("validate code:{}", validateCode);
		validateImageDTO.setValidateCode(validateCode);
		validateImageDTO.setBufferedImage(producer.createImage(validateCode));
		return validateImageDTO;
	}

}

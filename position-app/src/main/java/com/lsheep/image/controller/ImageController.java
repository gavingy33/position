package com.lsheep.image.controller;

import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;
import com.lsheep.image.dto.ValidateImageDTO;
import com.lsheep.image.service.ValidateService;

@Controller
@RequestMapping(value = "/image")
public class ImageController {

	@Resource
	private ValidateService validateService;

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public void validate(HttpServletRequest request, HttpServletResponse response) {
		try (OutputStream outputStream = response.getOutputStream()) {
			ValidateImageDTO validateImageDTO = validateService.produce();
			request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, validateImageDTO.getValidateCode());
			ImageIO.write(validateImageDTO.getBufferedImage(), "png", outputStream);
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

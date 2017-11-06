package com.lsheep.image.dto;

import java.awt.image.BufferedImage;

public class ValidateImageDTO {

	private String validateCode;
	private BufferedImage bufferedImage;

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

}

package com.lsheep.image.service;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.junit.Test;

import com.lsheep.BaseTester;
import com.lsheep.image.dto.ValidateImageDTO;

public class TestValidateService extends BaseTester {

	@Resource
	private ValidateService validateService;

	private final String PATH = "/Users/gaofeng/share/validate/";

	@Test
	public void testProduce() {
		ValidateImageDTO validateImage = validateService.produce();
		try (FileOutputStream outputStream = new FileOutputStream(PATH + validateImage.getValidateCode() + ".png")) {
			BufferedImage bufferedImage = validateImage.getBufferedImage();
			ImageIO.write(bufferedImage, "png", outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

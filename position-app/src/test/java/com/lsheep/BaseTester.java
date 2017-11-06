package com.lsheep;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:ApplicationContext.xml")
public class BaseTester {

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

}
